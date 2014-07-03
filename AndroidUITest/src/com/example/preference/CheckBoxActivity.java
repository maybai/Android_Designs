package com.example.preference;

import android.R;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class CheckBoxActivity extends PreferenceActivity {
	Context mContext = null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//Add preference from res, the selected value will be saved in sharePreference
		//addPreferenceFromResource(R.xml.checkbox);
		mContext = this;
		
		//CheckBoxPreference element
		CheckBoxPreference mCheckbox0 = (CheckBoxPreference)findPreference("checkbox_0");
		mCheckbox0.setOnPreferenceClickListener(new OnPreferenceClickListener(){
			@Override
			public boolean onPreferenceClick(Preference preference){
				//Listen to the event of CheckBox click
				return true;
			}
		});
		mCheckbox0.setOnPreferenceChangeListener(new OnPreferenceChangeListener(){
			@Override
			public boolean onPreferenceChange(Preference arg0, Object newValue){
				//Get the value in checkbox is changed or not
				//Get the value if changed
				Toast.makeText(mContext, "checkBox_0 value is:" + (Boolean)newValue, Toast.LENGTH_LONG).show();
				return true;
			}
		});
		
		CheckBoxPreference mCheckbox1 = (CheckBoxPreference) findPreference("checkbox_1");
        mCheckbox1.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //这里可以监听到这个CheckBox 的点击事件
                return true;
            }
        });
        
        mCheckbox1.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
            
            @Override
            public boolean onPreferenceChange(Preference arg0, Object newValue) {
                //这里可以监听到checkBox中值是否改变了
                //并且可以拿到新改变的值
                  Toast.makeText(mContext, "checkBox_1改变的值为" +  (Boolean)newValue, Toast.LENGTH_LONG).show();  
                return true;
            }
        });
	}

}
