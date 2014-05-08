package com.example.mytest1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class PlayService extends Service {
	String TAG = "ServiceActivity";
	MediaPlayer mediaPlayer;
	
	/**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
    public class LocalBinder extends Binder {
		PlayService getService() {
            return PlayService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // This is the object that receives interactions from clients.  See
    // RemoteService for a more complete example.
    private final IBinder mBinder = new LocalBinder();
    
	public void onCreate(){
		super.onCreate();
		Toast.makeText(this, "Play service is created", Toast.LENGTH_LONG);
		Log.v(TAG, "ServiceOnCreate");
		mediaPlayer = MediaPlayer.create(this, R.raw.baihu);
		/*
	     * 要用MediaPlayer来创建，不能用MediaPlayer的对象来创建 // 不用带后缀 mediaPlayer = new
	     * MediaPlayer(); mediaPlayer.create(this, R.raw.test);
	     */
	
	    /*
	     * try { mediaPlayer.setDataSource("/sdcard/music/lost times.mp3");
	     * mediaPlayer.prepare();
	     * 
	     * 
	     * //方法二，从网上的链接获取歌曲 try { mediaPlayer.setDataSource(
	     * "http://www.yousss.com/uploadfile/mp3/2007-11/20071129134414713.mp3"
	     * );
	     */
	
	    // mediaPlayer.setLooping(true);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){
		super.onStartCommand(intent, flags, startId);
		/*
         * //可以在OnCreate里面创建与音乐的链接，也可以在OnStart里面创建 mediaPlayer =
         * MediaPlayer.create(this, R.raw.test);
         */
		Toast.makeText(this, "PlayService started", Toast.LENGTH_LONG);
		Log.v(TAG, "ServiceonStart");
		mediaPlayer.start();
		return START_STICKY;
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
		Toast.makeText(this, "PlayService Destroyed", Toast.LENGTH_LONG);
		Log.v(TAG, "ServiceonDestroy");
		mediaPlayer.stop();
	}
}
