package com.example.broadcasttest;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
	private MyBinder myBinder;
	private final static String TAG = MyService.class.getSimpleName();
	@Override
	public IBinder onBind(Intent intent){
		return myBinder;		
	}
	@Override
	public void onCreate(){
		super.onCreate();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		super.onStartCommand(intent, flags, startId);
		
		return START_STICKY;
	}
	@Override
	public boolean onUnbind(Intent intent){
		return super.onUnbind(intent);
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
	
	public class MyBinder extends Binder{
		MyService getService(){
			return MyService.this;
		}
	}

}
