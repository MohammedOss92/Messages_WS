package com.messages.abdallah.mymessages.Classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by MUNZ 1985 on 12/6/2016.
 */
public class ActivityHelper {

    public static void gotoActivity (Context context , Class<?> to , Bundle bundle , boolean finish)
    {
        Intent i = new Intent(context,to);
        i.putExtras(bundle);
        context.startActivity(i);
        if(finish)
        {
            ((Activity)context).finish();
        }
    }

//    Bundle b = new Bundle();
//    ActivityHelper.gotoActivity(MainActivity.this,MessageActivity.class,b,true);
}
