package com.example.provider;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyContentDemo extends Activity {
	
	private static final String TAG = "MyContentDemo";
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String userName = intent.getStringExtra(MyUsers.User.USER_NAME);
		insertRecord(userName);
		//insertRecord("MyUser");
		displayRecords();
	}
	
	private void insertRecord(String userName){
		//ContentValues values = new ContentValues();
		//values.put(MyUsers.User.USER_NAME, userName);
		//getContentResolver().insert(MyUsers.User.CONTENT_URI, values);
		Log.v(TAG, "1");
		Log.i(TAG, "2");
		Log.d(TAG, "");
		Log.w("Data printing.....", "3");
		Log.e("Data printing.....", "");
	}
	private void displayRecords(){
		String columns[] = new String []{MyUsers.User._ID, MyUsers.User.USER_NAME};
		Uri myUri = MyUsers.User.CONTENT_URI;
		Cursor cur = getContentResolver().query(myUri, columns, null, null, null);
		if(cur.moveToFirst()){
			String id = null;
			String userName = null;
			do{
				id = cur.getString(cur.getColumnIndex(MyUsers.User._ID));
				userName = cur.getString(cur.getColumnIndex(MyUsers.User.USER_NAME));
				Toast.makeText(this,  id + " " + userName, Toast.LENGTH_LONG).show();
			}while (cur.moveToNext());
		}
		cur.close();
	}
}
