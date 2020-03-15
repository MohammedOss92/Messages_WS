package com.messages.abdallah.mymessages.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.messages.abdallah.mymessages.ActivityText;
import com.messages.abdallah.mymessages.R;

import java.util.List;

import com.messages.abdallah.mymessages.Classes.Messages;
import com.messages.abdallah.mymessages.SqliteClasses.Sqlite;
import com.messages.abdallah.mymessages.Utils.Utils;

/**
 * Created by MUNZ 1985 on 8/8/2015.
 */
public class MessagesAdapter extends BaseAdapter {
    Context c;
    List<Messages> myArrayList;
    LayoutInflater inflater;
    int textSize;

    public MessagesAdapter(Context c, List<Messages> myArrayList, int textSize) {
        this.c = c;
        this.myArrayList = myArrayList;
        this.textSize = textSize;
    }

    @Override
    public int getCount() {
        return myArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return myArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (inflater == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.lv_msg_design, null);
            holder = new ViewHolder();

            holder.tvMsg = (TextView) convertView.findViewById(R.id.tvMsg);
            holder.share = (ImageView) convertView.findViewById(R.id.share);
            holder.copy = (ImageView) convertView.findViewById(R.id.copy);
            holder.imgNewMsg = (ImageView) convertView.findViewById(R.id.new_Msg);
            holder.imgFav = (ImageView) convertView.findViewById(R.id.fav);
            holder.shared = (ImageView) convertView.findViewById(R.id.shared);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.shared.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = holder.tvMsg.getText().toString();
                    waIntent.setPackage("com.whatsapp");
                    if (waIntent != null) {
                        waIntent.putExtra(Intent.EXTRA_TEXT, text);//
                        c.startActivity(Intent.createChooser(waIntent, "Share with"));
                    } else {
                        Toast.makeText(c, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                                .show();
                    }
                    Animation animation = AnimationUtils.loadAnimation(c, R.anim.anim_rotate);
                    holder.shared.startAnimation(animation);
                }
            });

            holder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder popDialog = new AlertDialog.Builder(c);
                    popDialog.setTitle("هل ترغب بتعديل النص");

                    popDialog.setNegativeButton("نعم", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            Intent i = new Intent(c, ActivityText.class);
                            String data = holder.tvMsg.getText().toString();
                            i.putExtra("na", holder.tvMsg.getText().toString());
                            c.startActivity(i);
                        }
                    });

                    popDialog.setPositiveButton("لا", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            Utils.IntenteShare(c, "مسجاتي", "مسجاتي", holder.tvMsg.getText().toString());
                        }
                    });
                    //com.messages.abdallah.mymessages.Utils.IntenteShare(c, "مسجاتي", "مسجاتي", holder.tvMsg.getText().toString());
                    Animation animation = AnimationUtils.loadAnimation(c, R.anim.anim_rotate);
                    holder.share.startAnimation(animation);
                    popDialog.show();
                }
            });


            holder.copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String stringYouExtracted = holder.tvMsg.getText().toString();
                    if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) c.getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(stringYouExtracted);
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) c.getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData
                                .newPlainText(stringYouExtracted, stringYouExtracted);
                        clipboard.setPrimaryClip(clip);
                    }
                    Toast.makeText(c, "تم نسخ النص", Toast.LENGTH_SHORT).show();
                    Animation animation = AnimationUtils.loadAnimation(c, R.anim.anim_rotate);
                    holder.copy.startAnimation(animation);
                }
            });


            convertView.setTag(holder);


        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        final Messages m = myArrayList.get(position);

        holder.tvMsg.setText(m.getMsgDescription());
        holder.tvMsg.setTextColor(Color.BLACK);


        if (m.getNewMsg() == 0) {
            holder.imgNewMsg.setVisibility(View.INVISIBLE);

        } else {
            holder.imgNewMsg.setVisibility(View.VISIBLE);
        }


        final Sqlite s = new Sqlite(c);

        int titleId = m.getTypeId();
        String titleDesc = s.getMsgTitleByTitleID(titleId);
        holder.tvTitle.setText(titleDesc);

        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (s.getIFMsgIsFav(m) == 0) {
                    holder.imgFav.setBackgroundResource(R.mipmap.f);
                    s.changeFav(m, 1);
                    Toast.makeText(c, "تم الإضافة للمفضله", Toast.LENGTH_SHORT).show();
                } else {
                    holder.imgFav.setBackgroundResource(R.mipmap.nf);
                    s.changeFav(m, 0);
                    Toast.makeText(c, "تم الإزالة من المفضله", Toast.LENGTH_SHORT).show();
//                    myArrayList.remove(position);
                }

                Animation animation = AnimationUtils.loadAnimation(c, R.anim.anim_rotate);
                holder.imgFav.startAnimation(animation);
            }
        });


        if (s.getIFMsgIsFav(m) == 0) {
            holder.imgFav.setBackgroundResource(R.mipmap.nf);

        } else {
            holder.imgFav.setBackgroundResource(R.mipmap.f);

        }
        return convertView;
    }


    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }


    private class ViewHolder {
        TextView tvMsg;
        //        ImageView imageView;
        ImageView share;
        ImageView copy;
        ImageView imgNewMsg;
        ImageView imgFav;
        ImageView shared;
        TextView tvTitle;
    }
}
