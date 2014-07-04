package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ThirdReceiver extends BroadcastReceiver {
	private final static String TAG = "OrderedBroadcastReceiver";
	@Override
	public void onReceive(Context context, Intent intent){
		String msg = getResultExtras(true).getString("msg");
		Log.d(TAG, "ThirdReceiver:" + msg);

		
		Intent activityIntent = new Intent (context, MessageActivity.class);
		activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		activityIntent.putExtra("msg", msg);
		context.startActivity(activityIntent);
	}

}
