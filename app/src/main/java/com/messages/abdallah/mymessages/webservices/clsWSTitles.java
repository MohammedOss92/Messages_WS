package com.messages.abdallah.mymessages.webservices;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

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
import com.messages.abdallah.mymessages.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.messages.abdallah.mymessages.SqliteClasses.Sqlite;
import com.messages.abdallah.mymessages.Classes.CustomMsgTypes;

/**
 * Created by MUNZ 1985 on 8/8/2015.
 */
public class clsWSTitles


{

    Context context;
    List<CustomMsgTypes> titleItems;
    ProgressDialog progress;
    public clsWSTitles  (Context c)
    {
        context=c;
    }

    private String strWSURL;
    Map<String, String> params ;
    MainActivity callingActivity;
    public void readJSON(String strLang, final boolean isRefresh)
    {
        strWSURL=  context.getResources().getString(R.string.titles_ws);
        //RequestQueue q = Volley.newRequestQueue(context);
        params=new HashMap<String, String>();

        progress=new ProgressDialog(context);
        progress.setTitle("الرجاء الانتظار");
       // progress.show();
        //////////////////////////
       RequestQueue queue = Volley.newRequestQueue(context);


        StringRequest req = new StringRequest(Request.Method.POST, strWSURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String ss) {

                // Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();


try{


                    JSONObject response = new JSONObject(ss);
                    JSONArray jor = response.getJSONArray("MyPersons");


                        if(isRefresh) {
                            Sqlite s = new Sqlite(context);
                            s.clearTables();
                        }
                        //JSONArray jor=response.getJSONArray("MyTitles");
                        titleItems=new ArrayList<CustomMsgTypes>();
                        for(int i=0;i<jor.length();i++)
                        {
                            JSONObject obj=jor.getJSONObject(i);
                            String title=obj.getString("typeDescription");
                            int id=obj.getInt("typeID");
                            int newMsg=obj.getInt("newMsg");
                            CustomMsgTypes n=new CustomMsgTypes();
                            n.setTitleDesc(title);
                            n.setTitleID(id);
                            n.setNewMsg(newMsg);
                            titleItems.add(n);
                            //added for SQlite *******************//
                            try {
                                Sqlite s = new Sqlite(context);
                                s.saveMsgTypes(n);
                                clsWSMessages ws=new clsWSMessages(context);
                                ws.readJSON(id,false);

                            }
                            catch(Exception ex)
                            {
                                String h="";
                            }
                            //////////////////////////////////////
                            //   Toast.makeText(context,title,Toast.LENGTH_LONG).show();

                        }
                        progress.dismiss();
                        callingActivity=(MainActivity)context;
                        // Removed because we wamt to read from SQlite
                        // callingActivity.fillData(true,titleItems);
                        callingActivity.fillData();








                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                        progress.dismiss();
                        callingActivity=(MainActivity)context;
                        // callingActivity.fillNewsOnLine(false, newsItems);

                        callingActivity.fillData();
                    }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String errorDescription = "";
                if( volleyError instanceof NetworkError) {
                } else if( volleyError instanceof ServerError) {
                    errorDescription="Server Error";
                } else if( volleyError instanceof AuthFailureError) {
                    errorDescription="AuthFailureError";
                } else if( volleyError instanceof ParseError) {
                    errorDescription="Parse Error";
                } else if( volleyError instanceof NoConnectionError) {
                    errorDescription="No Conenction";
                } else if( volleyError instanceof TimeoutError) {
                    errorDescription="Time Out";
                }

                callingActivity=(MainActivity)context;
                // callingActivity.fillNewsOnLine(false,newsItems);

                progress.dismiss();
                callingActivity.fillData();
//                Toast.makeText(context, "Error:" + error,Toast.LENGTH_LONG).show() ;
                Toast.makeText(context, errorDescription, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<String,String>();

               // param.put("typeID",titleID+"");
                return param;
            }
        };

        queue.add(req);}


        /////////////////////////

//        CustomJSON jsObjRequest = new CustomJSON(Request.Method.GET,strWSURL ,params,
//                new Response.Listener<JSONObject>()
//                {
//                    public void onResponse(JSONObject response)
//                    {
//
//
//                        try
//                        {
//
//                            if(isRefresh) {
//                                Sqlite s = new Sqlite(context);
//                                s.clearTables();
//                            }
//                                JSONArray jor=response.getJSONArray("MyTitles");
//                                titleItems=new ArrayList<CustomMsgTypes>();
//                                for(int i=0;i<jor.length();i++)
//                                {
//                                    JSONObject obj=jor.getJSONObject(i);
//                                    String title=obj.getString("typeDescription");
//                                    int id=obj.getInt("typeID");
//                                    int counter=obj.getInt("countOfMessages");
//                                    int newMsg=obj.getInt("newMsg");
//                                    CustomMsgTypes n=new CustomMsgTypes();
//                                    n.setTitleDesc(title);
//                                    n.setTitleID(id);
//                                    n.setCounter(counter);
//                                    n.setNewMsg(newMsg);
//                                    titleItems.add(n);
//                                    //added for SQlite *******************//
//                                    try {
//                                        Sqlite s = new Sqlite(context);
//                                        s.saveMsgTypes(n);
//                                        clsWSMessages ws=new clsWSMessages(context);
//                                        ws.readJSON(id,false);
//
//                                    }
//                                    catch(Exception ex)
//                                    {
//String h="";
//                                    }
//                                    //////////////////////////////////////
//                                    //   Toast.makeText(context,title,Toast.LENGTH_LONG).show();
//
//                                }
//                                progress.dismiss();
//                                callingActivity=(MainActivity)context;
//                               // Removed because we wamt to read from SQlite
//                               // callingActivity.fillData(true,titleItems);
//                                callingActivity.fillData();
//
//
//
//
//
//
//
//
//                        }
//                        catch (JSONException e)
//                        {
//                            e.printStackTrace();
//                            progress.dismiss();
//                            callingActivity=(MainActivity)context;
//                           // callingActivity.fillNewsOnLine(false, newsItems);
//
//                            callingActivity.fillData();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener()
//                {
//                    @Override
//                    public void onErrorResponse(VolleyError error)
//                    {
//                        callingActivity=(MainActivity)context;
//                       // callingActivity.fillNewsOnLine(false,newsItems);
//
//                        progress.dismiss();
//                        callingActivity.fillData();
//                        Toast.makeText(context, "Error:" + error,Toast.LENGTH_LONG).show() ;
//                    }
//                }
//
//
//
//
//
//
//
//
//        );
//
//
//        q.add(jsObjRequest);
//    }



    private void setTheCallingActivity(Activity a)
    {

    }
}
