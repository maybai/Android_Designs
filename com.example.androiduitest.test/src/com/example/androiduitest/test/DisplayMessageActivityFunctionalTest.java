package com.example.androiduitest.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androiduitest.R;
import com.example.androiduitest.DisplayMessageActivity;


public class DisplayMessageActivityFunctionalTest extends
    ActivityInstrumentationTestCase2<DisplayMessageActivity> {

  private static final String NEW_TEXT = "new text";

  public DisplayMessageActivityFunctionalTest() {
    super(DisplayMessageActivity.class);
  }

  public void testSetText() throws Exception {

	DisplayMessageActivity activity = getActivity();

    // search for the textView
    final TextView textView = (TextView) activity
        .findViewById(R.id.show_message);

    // set text
    getActivity().runOnUiThread(new Runnable() {

      @Override
      public void run() {
        textView.setText(NEW_TEXT);
      }
    });
    
    getInstrumentation().waitForIdleSync();
    assertEquals("Text incorrect", NEW_TEXT, textView.getText().toString());

  }

  @UiThreadTest
  public void testSetTextWithAnnotation() throws Exception {

	  DisplayMessageActivity activity = getActivity();

    // search for the textView
    final TextView textView = (TextView) activity
        .findViewById(R.id.show_message);

    textView.setText(NEW_TEXT);
    assertEquals("Text incorrect", NEW_TEXT, textView.getText().toString());

  }

}
