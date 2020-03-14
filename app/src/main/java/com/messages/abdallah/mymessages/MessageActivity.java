package com.messages.abdallah.mymessages;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;


import java.util.List;

import Classes.Messages;
import SqliteClasses.Sqlite;
import adapters.CustomMsgTypes;
import adapters.MSgTypesAdapters;
import adapters.MessagesAdapter;
import webservices.clsWSMessages;


public class MessageActivity extends AppCompatActivity {
    int titleID;
    ListView lvMessages;
    EditText et;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aa);
        setTitle(null);
     }


    @Override
    protected void onResume() {
        super.onResume();
        ll= (LinearLayout) findViewById(R.id.ll);

        //      Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        //     setSupportActionBar(topToolBar);

        lvMessages=(ListView) findViewById(R.id.lvMessages);





//        lvMessages.addHeaderView(new View(this));
//        lvMessages.addFooterView(new View(this));

        et=(EditText)findViewById(R.id.editText);

        Intent i=getIntent();
        clsWSMessages ws=new clsWSMessages(this);
        if (i.getExtras()!=null) {
            titleID = i.getExtras().getInt("titleID");
        }
           else
            {
              titleID=1;
            }

        fillData();
        if(lvMessages.getAdapter().getCount()==0) {
            ws.readJSON(titleID, true);
        }
        lvMessages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //Intent i = new Intent(MessageActivity.this,TextMsg.class);

                // Messages m=(Messages)parent.getItemAtPosition(position);

                //i.putExtra("msg",m.getMsgDescription());
                //startActivity(i);

                Intent i = new Intent(MessageActivity.this,Pager_Messages.class);

                Messages m=(Messages)parent.getItemAtPosition(position);

                i.putExtra("titleID",m.getTypeId());
                i.putExtra("pos",position);
                i.putExtra("filter",et.getText().toString());
                i.putExtra("msgID",m.getMsgID());
                i.putExtra("origPos",m.getOrigPos());
                i.putExtra("newMsg",m.getNewMsg());
                i.putExtra("sourceIsFav",false);

                startActivity(i);
                lvMessages.setEnabled(true);

            }
        });


        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                //Code For JSON
                // clsWSMsgSearch ws=new clsWSMsgSearch(MessageActivity.this);
                // ws.readJSON(titleID,et.getText().toString());

                //Code For SQLITE

                Sqlite ss=new Sqlite(getApplicationContext());
                List<Messages> myArrayList=  ss.getMessagesFiltered(titleID, et.getText().toString());
                MessagesAdapter a=new MessagesAdapter(getApplicationContext(),myArrayList,20);

                lvMessages.setAdapter(a);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

//    public void mansaf (View view)
//    {
//
//        clsWSMsgSearch ws=new clsWSMsgSearch(this);
//
//
//        ws.readJSON(titleID, et.getText().toString());
//    }


    //This code for web service
    public void fillData(boolean success,List<String> myArrayList)
    {

        ArrayAdapter<String> a=new ArrayAdapter(this,android.R.layout.simple_list_item_1,myArrayList);
        lvMessages.setAdapter(a);
    }

    //This Code From Sqlite
    public void fillData()
    {
        Sqlite s=new Sqlite(this);
        List<Messages> myArrayList=  s.getMessages(titleID);
        MessagesAdapter a=new MessagesAdapter(this,myArrayList,20);
        lvMessages.setAdapter(a);
    }



    private void RadioButtonDialog() {
        // custom dialog
        final Dialog dialog = new Dialog(MessageActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_design);
        dialog.setTitle("تغيير اللون");
        RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);
        final RadioButton light =(RadioButton)dialog.findViewById(R.id.light);
        RadioButton dark =(RadioButton)dialog.findViewById(R.id.dark);

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.setBackgroundColor(Color.WHITE);

            }
        });

        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvMessages.setBackgroundColor(Color.BLACK);
                //tv.setTextColor(Color.WHITE);
            }
        });


        dialog.show();
    }


    /////////////////////////////////////////////////

//    private void SeekBar() {
//        final AlertDialog.Builder popDialog = new AlertDialog.Builder(MessageActivity.this);
//
//        final SeekBar seek = new SeekBar(MessageActivity.this);
//
//        seek.setMax(100);
//        seek.setProgress(globalTextSize);
//        seek.refreshDrawableState();
//        popDialog.setTitle("حجم الخط");
//
//        popDialog.setView(seek);
//        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//                globalTextSize=progress;
//                tv.setTextSize(progress);
//                SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(MessageActivity.this);
//                SharedPreferences.Editor et=sp.edit();
//                et.putInt("txtSize",progress);
//                et.commit();
//
//            }
//            public void onStartTrackingTouch(SeekBar arg0) {
//
//            }
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//
//            }
//        });
////// Button OK
////            popDialog.setPositiveButton("تم", new DialogInterface.OnClickListener() {
////
////                public void onClick(DialogInterface dialog, int which) {
////                    dialog.dismiss();
////                }
////            });
//
//        popDialog.create();
//
//        popDialog.show();
//
//
//
//
//
//
//    }
    ////////////////////////////////////

}
