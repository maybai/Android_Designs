package com.example.myserviceactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button bt_start, bt_stop, bt_bind, bt_unbind, bt_exit;
	private Button bt_send_broadcast;
	private Intent st1_intent;
	private ServiceTest1 st1;
	boolean mBound = false; //Must set the flag, or force-close while unBindservice

	private ServiceConnection sc = new ServiceConnection(){
		//Invoke the method while connecting fail
		@Override
		public void onServiceDisconnected(ComponentName name){
			mBound = false;
			Toast.makeText(getApplicationContext(), "Service Failed", Toast.LENGTH_LONG).show();;
		}
		//Invoke the method while connecting succeed
		@Override
		public void onServiceConnected(ComponentName name, IBinder service){
			st1 = ((ServiceTest1.MyBinder)service).getService();
			Toast.makeText(getApplicationContext(), "Service Connected.", Toast.LENGTH_LONG).show();   
			mBound = true;
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		st1_intent = new Intent(this, ServiceTest1.class);
		bt_start = (Button)findViewById(R.id.bt_start_service);
		bt_stop = (Button)findViewById(R.id.bt_stop_service);
		bt_bind = (Button)findViewById(R.id.bt_bind_service);
		bt_unbind = (Button)findViewById(R.id.bt_unbind_service);
		bt_exit = (Button)findViewById(R.id.bt_exit);
		bt_start.setOnClickListener(this);//注意这个地方的使用,or the click will not be responded
		bt_stop.setOnClickListener(this);
		bt_bind.setOnClickListener(this);
		bt_unbind.setOnClickListener(this);
		bt_exit.setOnClickListener(this);
		
		//Broadcast test
		bt_send_broadcast = (Button)findViewById(R.id.bt_send_broadcast);
		bt_send_broadcast.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v){
		switch (v.getId()){
			case R.id.bt_start_service:
				startService(st1_intent);
				break;
			case R.id.bt_stop_service:
				stopService(st1_intent);
				break;
			case R.id.bt_bind_service:
				bindService(st1_intent, sc, Context.BIND_AUTO_CREATE); //static 常量直接用类名调用
				break;
			case R.id.bt_unbind_service:
				if (mBound) {
		            unbindService(sc);
		            mBound = false;
		        }
				break;
			case R.id.bt_send_broadcast:
				//sendBroadcast();
				//sendOrderedBroadcast();
				testMyContentProvider();
				break;
			case R.id.bt_exit:
				System.exit(0);
				break;
			default:
				break;
		}
	}

	public void sendBroadcast(){
		Intent intent = new Intent ("android.intent.action.MY_BROADCAST");
		intent.putExtra("msg", "My Message");
		sendBroadcast(intent); //send normal Broadcast		
	}
	public void sendOrderedBroadcast(){
		Intent intent = new Intent ("android.intent.action.MY_BROADCAST");
		intent.putExtra("msg", "My Message");
		sendOrderedBroadcast(intent, null);
		//sendOrderedBroadcast(intent,"com.example.myserviceactivity.MY_BROADCAST_PERMISSION"); //send ordered broadcast
	}
	
	public void testMyContentProvider(){
		Intent intent = new Intent(this, com.example.provider.MyContentDemo.class);
		intent.putExtra(com.example.provider.MyUsers.User.USER_NAME, "BaiMay");
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
