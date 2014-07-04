package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class FirstReceiver extends BroadcastReceiver{
	private final static String TAG = "OrderedBroadcastReceiver";
	@Override
	public void onReceive(Context context, Intent intent){
		String msg = intent.getStringExtra("msg");
		Log.d(TAG, "FirstReceiver:" + msg);
		Bundle bundle = new Bundle();
		bundle.putString("msg", msg + "@FirstReceiver");
		setResultExtras(bundle); //必须用sendOrderedBroadcast（）发出广播，否则会有异常：trying to return a result 
								//during a non-ordered broadcast
		/*
		Intent activityIntent = new Intent (context, MessageActivity.class);
		activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		activityIntent.putExtra("msg", msg);
		context.startActivity(activityIntent);
		*/
	}
}