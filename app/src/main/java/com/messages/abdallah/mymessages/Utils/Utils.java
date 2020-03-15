package com.messages.abdallah.mymessages.Utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Utils {
	public static void IntenteShare(Context c, String dialog_Heder_text,
									String heder, String Msg) {
		try {
			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
			sharingIntent.putExtra(Intent.EXTRA_SUBJECT, heder);
			sharingIntent.putExtra(Intent.EXTRA_TEXT, Msg);
			c.startActivity(Intent.createChooser(sharingIntent,
					dialog_Heder_text));
		} catch (Exception e) {
			Log.d("error in share", e.toString());

		}}





}
