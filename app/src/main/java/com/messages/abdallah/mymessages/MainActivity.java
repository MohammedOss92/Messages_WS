package com.messages.abdallah.mymessages;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
//
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.firebase.analytics.FirebaseAnalytics;
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;


import java.util.ArrayList;
import java.util.List;

import SqliteClasses.Sqlite;
import adapters.CustomMsgTypes;
import adapters.MSgTypesAdapters;
import webservices.clsWSTitles;

public class MainActivity extends AppCompatActivity {
    ListView lvTitles;
    private List<CustomMsgTypes> myArrayList = new ArrayList<>();
    MSgTypesAdapters a;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        lvTitles = (ListView) findViewById(R.id.lvMessageTypes);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        //check For Internet


        fillData();
        if (lvTitles.getAdapter().getCount() == 0) {
            clsWSTitles obj = new clsWSTitles(this);
            obj.readJSON("", false); // read data just for title so we put it false , while in auto refresh we need data for messages also
        }

        // else


        // myArrayList=new ArrayList<CustomMsgTypes>();

        lvTitles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lvTitles.getItemAtPosition(position);
                CustomMsgTypes cm = (CustomMsgTypes) o;

                Intent i = new Intent(MainActivity.this, MessageActivity.class);

                i.putExtra("titleID", cm.getTitleID());
                startActivity(i);
                lvTitles.setEnabled(true);



            }
//                mInterstitial.loadAd(new AdRequest.Builder().build());
//                lvTitles.setEnabled(true);
//            }
        });








    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_fav) {
            Intent i=new Intent(MainActivity.this,FavMessageActivity.class);
            startActivity(i);
            return false;
        }
        else if(id==R.id.action_refresh)
        {

            clsWSTitles obj = new clsWSTitles(this);
            // Sqlite s=new Sqlite(this);
            //s.clearTables();
            obj.readJSON("",true);

            return false;
        }

        return super.onOptionsItemSelected(item);
    }


    public void favClick(View v)
    {
        Intent i=new Intent(this,FavMessageActivity.class);
        startActivity(i);
    }

    //This Code To Fill from Web Service
    public void fillData(boolean success,List<CustomMsgTypes> myArrayList)
    {
        this.myArrayList=myArrayList;
        MSgTypesAdapters a=new MSgTypesAdapters(this,myArrayList);
        lvTitles.setAdapter(a);
    }

    //This Code From Sqlite
    public void fillData()
    {
        Sqlite s=new Sqlite(this);
        List<CustomMsgTypes> myArrayList=  s.getMsgTypes();
        MSgTypesAdapters a=new MSgTypesAdapters(this,myArrayList);
        lvTitles.setAdapter(a);
    }


}
