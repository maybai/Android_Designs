package com.example.broadcasttest;

import com.example.myserviceactivity.ServiceTest1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartupReceiver extends BroadcastReceiver{
	private final static String TAG = StartupReceiver.class.getSimpleName();
	@Override
	public void onReceive(Context context, Intent intent){
		String msg = intent.getStringExtra("msg");
		Log.d(TAG, msg);
		//Start a Service
		Intent serviceIntent = new Intent (context, ServiceTest1.class);
		context.startService(serviceIntent);
		Intent activityIntent = new Intent (context, MessageActivity.class);
		activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		activityIntent.putExtra("msg", msg);
		context.startActivity(activityIntent);
	}

}
