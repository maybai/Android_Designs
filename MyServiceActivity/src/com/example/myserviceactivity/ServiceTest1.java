package com.example.myserviceactivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ServiceTest1 extends Service {
	
	private static final String TAG = "ServiceTest1";
	private MyBinder myBinder = new MyBinder();
	
	//Must implement the abstract method of onBind
	//成功绑定后调用该方法
	@Override
	public IBinder onBind(Intent intent){
		Log.d(TAG, "onBind");
		return myBinder;
	}
	//Invoke the method while rebinding service
	@Override
	public void onRebind(Intent intent){
		Log.d(TAG, "onReind");
		super.onRebind(intent);
	}
	//Invoke the method while unbind service
	@Override
	public boolean onUnbind(Intent intent){
		Log.d(TAG, "onUnbind");
		return super.onUnbind(intent);
	}
	//Invoke the method while first creating service
	@Override
	public void onCreate(){
		Log.d(TAG, "onCreate");
		super.onCreate();
	}
	//Invoke the method while destroying service
	@Override
	public void onDestroy(){
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
	//Invoke the method while start service
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		Log.d(TAG, "onStart");
		super.onStartCommand(intent, flags, startId);
		// We want this service to continue running until it is explicitly    // stopped, so return sticky.    
		return START_STICKY;
	}
	
	public class MyBinder extends Binder{
		ServiceTest1 getService(){
			return ServiceTest1.this;
		}
	}
}
