package com.example.androiduitest;

import android.app.Activity;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.androiduitest.MESSAGE";
	private NotificationManager notificationManager;  
    private PendingIntent pendingIntent;  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    /** Called when the user click the button
     * 
     */
    public void sendMessage(View v){
    	sendOrderedBroadcast();
    	
    	notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);  
        Intent intent = new Intent(this, DisplayMessageActivity.class);  
        pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);  

    	//Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText)findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	
    	Notification notification = new Notification();  
        notification.icon = R.drawable.ic_launcher;  
        notification.tickerText = "下载任务已添加到下载列表中,点击查看!";
        notification.when = System.currentTimeMillis(); //通知产生的时间，会在通知信息里显示
        notification.defaults = Notification.DEFAULT_SOUND;
        long[] vibrate = {0, 100, 200, 300};
        notification.vibrate = vibrate;
        //notification.setLatestEventInfo(this, "下载任务已启动", "下载任务已添加到下载列表中!", pendingIntent);  
        notificationManager.notify(0, notification);  

    	
    	Intent intent2 = new Intent ("android.intent.action.MY_BROADCAST");
		intent2.putExtra("msg", message);
		sendOrderedBroadcast(intent2, null); //send ordered broadcast
		
		
		
    	
    	startActivity(intent);    	
    }
    
    public void sendOrderedBroadcast(){
		Intent intent = new Intent ("android.intent.action.MY_BROADCAST");
		intent.putExtra("msg", "My Message");
		//sendOrderedBroadcast(intent, null);
		sendOrderedBroadcast(intent, null); //send ordered broadcast
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
