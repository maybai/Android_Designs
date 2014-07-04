package com.example.broadcasttest;

import com.example.myserviceactivity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_dialog);
		Intent intent = getIntent();
		String msg = intent.getStringExtra("msg");
		
		TextView tv_message;
		tv_message = (TextView)findViewById(R.id.tv_message);
		tv_message.setText(msg);
		
		// 这里你可以进行一些等待时的操作，我这里用8秒后显示Toast代理等待操作
        new Handler().postDelayed(new Runnable(){
            @Override 
            public void run(){
            	MessageActivity.this.finish();
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();  
            }  

        }, 8000); 
	}
}
