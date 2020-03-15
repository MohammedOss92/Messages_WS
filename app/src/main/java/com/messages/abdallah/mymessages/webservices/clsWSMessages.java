package com.messages.abdallah.mymessages.webservices;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.messages.abdallah.mymessages.MainActivity;
import com.messages.abdallah.mymessages.MessageActivity;
import com.messages.abdallah.mymessages.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.messages.abdallah.mymessages.Classes.Messages;
import com.messages.abdallah.mymessages.SqliteClasses.Sqlite;

//import com.message.abdallah.mymessages.MainActivity;
//import com.message.abdallah.mymessages.MessageActivity;
//import com.message.abdallah.mymessages.R;

/**
 * Created by MUNZ 1985 on 8/8/2015.
 */
public class clsWSMessages


{

    Context context;
    List<String> msgItems;
    ProgressDialog progress;
    public clsWSMessages(Context c)
    {
        context=c;
    }

    private String strWSURL;
    //Map<String, String> params ;
    MessageActivity callingActivity;

    public void readJSON(final int titleID, final boolean goToMessages) {
        strWSURL = context.getResources().getString(R.string.messages_ws);
   //     RequestQueue q = Volley.newRequestQueue(context);
//        params = new HashMap<String, String>();
//        params.put("typeID", titleID + "");
        progress = new ProgressDialog(context);
        progress.setTitle("الرجاء الانتظار");
        progress.show();
/////////////////////////////





        //kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk


        RequestQueue queue = Volley.newRequestQueue(context);


        StringRequest req = new StringRequest(Request.Method.POST, strWSURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String ss) {

                // Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                try {




                    JSONObject response = new JSONObject(ss);
                    JSONArray jor = response.getJSONArray("MyPersons");
                    msgItems = new ArrayList<String>();
                    for (int i = 0; i < jor.length(); i++) {
                        JSONObject obj = jor.getJSONObject(i);


                        String msg = obj.getString("MsgDescription");
                        //added for SQlite *******************//
                        int msgID = obj.getInt("MsgID");
                        int typeID = obj.getInt("TypeID");
                        int newMsg = obj.getInt("newMsg");
                        //**************************************

                        msgItems.add(msg);


                        //added for SQlite *******************//
                        Messages msgSQLite = new Messages();

                        msgSQLite.setMsgID(msgID);
                        msgSQLite.setMsgDescription(msg);
                        msgSQLite.setTypeId(typeID);
                        msgSQLite.setOrigPos(i);
                        msgSQLite.setNewMsg(newMsg);
                        // msgSQLite.setTitleDescription();
                        try {
                            Sqlite s = new Sqlite(context);
                            s.saveMessages(msgSQLite);

                        } catch (Exception ex) {
                            String w = "";
                        }
                        //************************************
                        //   Toast.makeText(context,title,Toast.LENGTH_LONG).show();

                        progress.dismiss();
                    }
                    Sqlite s = new Sqlite(context);
                    s.updateFavOnRefersh();
                    progress.dismiss();
                    if (goToMessages) {
                        callingActivity = (MessageActivity) context;
                        //This is for JSON
                        //  callingActivity.fillData(true,msgItems);
                        //This is for SQLite

                        callingActivity.fillData();

                    } else {

                        MainActivity callingAct = (MainActivity) context;
                        callingAct.fillData();
                    }






                } catch (JSONException e) {
                    e.printStackTrace();
                    progress.dismiss();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
//                String errorDescription = "";
                if( volleyError instanceof NetworkError) {
                } else if( volleyError instanceof ServerError) {
//                    errorDescription="Server Error";
                } else if( volleyError instanceof AuthFailureError) {
//                    errorDescription="AuthFailureError";
                } else if( volleyError instanceof ParseError) {
//                    errorDescription="Parse Error";
                } else if( volleyError instanceof NoConnectionError) {
//                    errorDescription="No Conenction";
                } else if( volleyError instanceof TimeoutError) {
//                    errorDescription="Time Out";
                }
                progress.dismiss();
//                Toast.makeText(context, errorDescription, Toast.LENGTH_SHORT).show();
//                Toast.makeText(context, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<String,String>();

                param.put("typeID",titleID+"");
                return param;
            }
        };

        queue.add(req);


        //kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk

//        RequestQueue queue = Volley.newRequestQueue(context);
//
//
//        StringRequest req = new StringRequest(Request.Method.POST, strWSURL, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String ss) {
//
//                // Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
//                try {
//
//
//                    JSONObject response = new JSONObject(ss);
//                    JSONArray jor = response.getJSONArray("MyMessages");
//                    msgItems = new ArrayList<String>();
//                    for (int i = 0; i < jor.length(); i++) {
//                        JSONObject obj = jor.getJSONObject(i);
//
//
//                        String msg = obj.getString("MsgDescription");
//                        //added for SQlite *******************//
//                        int msgID = obj.getInt("MsgID");
//                        int typeID = obj.getInt("TypeID");
//                        int newMsg = obj.getInt("newMsg");
//                        //**************************************
//
//                        msgItems.add(msg);
//
//
//                        //added for SQlite *******************//
//                        Messages msgSQLite = new Messages();
//
//                        msgSQLite.setMsgID(msgID);
//                        msgSQLite.setMsgDescription(msg);
//                        msgSQLite.setTypeId(typeID);
//                        msgSQLite.setOrigPos(i);
//                        msgSQLite.setNewMsg(newMsg);
//                        // msgSQLite.setTitleDescription();
//                        try {
//                            Sqlite s = new Sqlite(context);
//                            s.saveMessages(msgSQLite);
//
//                        } catch (Exception ex) {
//                            String w = "";
//                        }
//                        //************************************
//                        //   Toast.makeText(context,title,Toast.LENGTH_LONG).show();
//
//
//                    }
//                    Sqlite s = new Sqlite(context);
//                    s.updateFavOnRefersh();
//                    progress.dismiss();
//                    if (goToMessages) {
//                        callingActivity = (MessageActivity) context;
//                        //This is for JSON
//                        //  callingActivity.fillData(true,msgItems);
//                        //This is for SQLite
//
//                        callingActivity.fillData();
//
//                    } else {
//
//                        MainActivity callingAct = (MainActivity) context;
//                        callingAct.fillData();
//                    }
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                String errorDescription = "";
//                if (volleyError instanceof NetworkError) {
//                } else if (volleyError instanceof ServerError) {
//                    errorDescription = "Server Error";
//                } else if (volleyError instanceof AuthFailureError) {
//                    errorDescription = "AuthFailureError";
//                } else if (volleyError instanceof ParseError) {
//                    errorDescription = "Parse Error";
//                } else if (volleyError instanceof NoConnectionError) {
//                    errorDescription = "No Conenction";
//                } else if (volleyError instanceof TimeoutError) {
//                    errorDescription = "Time Out";
//                }
//                //    Toast.makeText(context, errorDescription,Toast.LENGTH_SHORT).show();
//                callingActivity = (MessageActivity) context;
//                // callingActivity.fillNewsOnLine(false,newsItems);
//
//                progress.dismiss();
//                Toast.makeText(context, "Error:" + errorDescription, Toast.LENGTH_LONG).show();
//
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> param = new HashMap<String, String>();
////                param.put("userName",etName.getText().toString());
//                //              param.put("password", etPassword.getText().toString());
//
//                params.put("typeID",titleID+"");
//                return param;
//            }
//        };
//
//        queue.add(req);


    }
}

