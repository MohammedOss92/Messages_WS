package adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.messages.abdallah.mymessages.R;

import java.util.List;

/**
 * Created by MUNZ 1985 on 8/8/2015.
 */
public class MSgTypesAdapters extends BaseAdapter {
    Context c;
    List<CustomMsgTypes> myArrayList;
    LayoutInflater inflater;
  public MSgTypesAdapters(Context c, List<CustomMsgTypes> myArrayList)
  {
      this.c=c;
      this.myArrayList=myArrayList;
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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder holder;

        if (inflater == null)
        { inflater = (LayoutInflater)  c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);}


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.lv_msg_types_design, null);
            holder = new ViewHolder();

            holder.tvTitle = (TextView) convertView
                    .findViewById(R.id.tvTitle);
            holder.tvCounter=(TextView) convertView.findViewById(R.id.tvCounter);
            holder.imgNewMsg=(ImageView) convertView.findViewById(R.id.new_Msg);
            convertView.setTag(holder);


        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        CustomMsgTypes m=myArrayList.get(position);

        holder.tvTitle.setText(m.getTitleDesc());
        if (m.getCounter()==0)
        {
            holder.tvCounter.setVisibility(View.INVISIBLE);

        }
        else
        {
            holder.tvCounter.setVisibility(View.VISIBLE);
        }

        holder.tvCounter.setText(m.getCounter()+"");

        if (m.getNewMsg()==0)
        {
            holder.imgNewMsg.setVisibility(View.INVISIBLE);

        }
        else
        {
            holder.imgNewMsg.setVisibility(View.VISIBLE);
        }


        return convertView;
    }


    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    private class ViewHolder
    {
        TextView tvTitle;
        TextView tvCounter;
        ImageView imgNewMsg;
    }
}
