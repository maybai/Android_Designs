package com.example.mytest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MusicPlayer extends Activity implements OnClickListener{
	
	private static final String TAG = "MusicPlayerActivity";;
	Button bt_play, bt_pause, bt_stop;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_player_main);
		bt_play = (Button)findViewById(R.id.play);
		bt_pause = (Button)findViewById(R.id.pause);
		bt_stop = (Button)findViewById(R.id.stop);
		
		bt_play.setOnClickListener(this);
		bt_pause.setOnClickListener(this);
		bt_stop .setOnClickListener(this);
		//this.startService(new Intent(this, PlayService.class));
	}
	
	@Override
	protected void onDestroy(){
		Log.v(TAG, "Activity destroy service");
		super.onDestroy();
		this.stopService(new Intent(this, PlayService.class ));
	}
	
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case(R.id.play):
			this.startService(new Intent(this,PlayService.class));
			break;
		case(R.id.pause):
			Intent mPause = new Intent();
			mPause.putExtra("pauseMusic", true);
			
			break;
		case(R.id.stop):
			this.stopService(new Intent(this, PlayService.class));
			break;
		default:
			break;
		}
	}
	
	public void pausePlayMusic(){
	}
	
	@Override
	protected void onStop(){
		Log.v(TAG, "Activity stop Service");
		super.onStop();
	}
}
