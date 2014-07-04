package com.example.sharedpreferences;

import com.example.myserviceactivity.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;

public class MySharedPreferenceActivity extends Activity{
	private static final String STRING_KEY = "S_KEY";
	private static final String BOOLEAN_KEY = "B_KEY";
	private static final String INT_KEY = "I_KEY";
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Get the object of Sharedpreference
		SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
		
		//save data
		Editor editor = sp.edit();
		editor.putString(STRING_KEY, "string");
		editor.putBoolean(BOOLEAN_KEY, true);
		editor.putInt(INT_KEY, 0);
		editor.commit();
		
		//invoke data
		Log.d("SP", sp.getString(STRING_KEY, "none"));
		Log.d("SP", sp.getString("NOT_EXIST", "none"));
	}

}
