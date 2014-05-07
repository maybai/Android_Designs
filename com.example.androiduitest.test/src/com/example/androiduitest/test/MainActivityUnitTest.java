package com.example.androiduitest.test;

import android.content.Intent;
import android.widget.Button;


import com.example.androiduitest.MainActivity;


public class MainActivityUnitTest extends
	android.test.ActivityUnitTestCase<MainActivity> {
	
	private int buttonId;
	private MainActivity activity;
	
	public MainActivityUnitTest() {
		super(MainActivity.class);
	}
	
		@Override
		protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
		    MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}
	
	public void testLayout(){
		buttonId = com.example.androiduitest.R.id.button_send;
		assertNotNull("Button not allow to be null", activity.findViewById(buttonId));
		Button view = (Button)activity.findViewById(buttonId);
		assertEquals("Incorrect lable of button", "Send", view.getText());
	}
	public void testIntentTriggerViaOnClick(){
		buttonId = com.example.androiduitest.R.id.button_send;		
		Button view = (Button)activity.findViewById(buttonId);
		assertNotNull("Button not allow to be null", view);
		view.performClick();
		
		// TouchUtils cannot be used, only allowed in 
	    // InstrumentationTestCase or ActivityInstrumentationTestCase2 
	  
	    // Check the intent which was started
	    Intent triggeredIntent = getStartedActivityIntent();
	    assertNotNull("Intent was null", triggeredIntent);
	    String data = triggeredIntent.getExtras().getString(activity.EXTRA_MESSAGE);
	    assertEquals("Incorrect data passed via the intent",
	        "http://www.vogella.com", data);
	  }

}
