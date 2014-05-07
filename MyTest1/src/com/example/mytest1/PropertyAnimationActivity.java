package com.example.mytest1;


import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;

public class PropertyAnimationActivity extends Activity implements OnClickListener{
	final String TAG = "PropertyAnimationActivity: ";
	private Button bt_alpha;  
	private Button bt_scaleX;  
	private Button bt_scaleY;  
	private Button bt_scaleXY;  
	private Button bt_translationX;  
	private Button bt_translationY;  
	private Button bt_translationXY;  
	private Button bt_rotationX;  
	private Button bt_rotationY;  
	private Button bt_rotation;  
	private Button bt_vpa;  
	
	private Button bt_x;  
	private Button bt_y;  
	private Button bt_xy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation_main);
		findView();
	}
	private void findView(){
		bt_alpha = (Button) findViewById(R.id.bt_alpha);  
         
        bt_scaleX = (Button) findViewById(R.id.bt_scaleX);  
        bt_scaleY = (Button) findViewById(R.id.bt_scaleY);  
        bt_scaleXY = (Button) findViewById(R.id.bt_scaleXY);  
          
        bt_translationX = (Button) findViewById(R.id.bt_translationX);  
        bt_translationY = (Button) findViewById(R.id.bt_translationY);  
        bt_translationXY = (Button) findViewById(R.id.bt_translationXY);  
          
        bt_rotationX = (Button) findViewById(R.id.bt_rotationX);  
        bt_rotationY = (Button) findViewById(R.id.bt_rotationY);  
        bt_rotation = (Button) findViewById(R.id.bt_rotation);  
          
        bt_x = (Button) findViewById(R.id.bt_x);  
        bt_y = (Button) findViewById(R.id.bt_y);  
        bt_xy = (Button) findViewById(R.id.bt_xy);  
          
        //ViewPropAnimator  
        bt_vpa = (Button) findViewById(R.id.bt_vpa);

        bt_alpha.setOnClickListener(this);  
	         
	    bt_scaleX.setOnClickListener(this);  
	    bt_scaleY.setOnClickListener(this);  
	    bt_scaleXY.setOnClickListener(this);  
	      
	    bt_translationX.setOnClickListener(this);  
		bt_translationY.setOnClickListener(this);  
		bt_translationXY.setOnClickListener(this);  
		
		bt_rotationX.setOnClickListener(this);  
		bt_rotationY.setOnClickListener(this);  
		bt_rotation.setOnClickListener(this);  
	
		bt_x.setOnClickListener(this);  
		bt_y.setOnClickListener(this);  
		bt_xy.setOnClickListener(this);  
	
		bt_vpa.setOnClickListener(this); 
	}
	
	@SuppressWarnings("null")
	@Override
	public void onClick(View v){
		ObjectAnimator objAnimator = null;
		switch(v.getId()){
		case R.id.bt_alpha:
			objAnimator = ObjectAnimator.ofFloat(bt_alpha, "alpha", 1f,0f);  
			objAnimator.setRepeatCount(1);
			objAnimator.setRepeatMode(ValueAnimator.REVERSE);
			objAnimator.setDuration(1000);
			objAnimator.start();
			break;
		case R.id.bt_scaleX:
			objAnimator = (ObjectAnimator)AnimatorInflater.loadAnimator(this, R.animator.scalex);
			objAnimator.setTarget(bt_scaleX);
			objAnimator.start();
			break;
		case R.id.bt_scaleY:
			objAnimator = ObjectAnimator.ofFloat(bt_scaleY, "scaleY", 1f,0f);  
			objAnimator.setRepeatCount(1);
			objAnimator.setRepeatMode(ValueAnimator.REVERSE);
			objAnimator.setDuration(1000);
			objAnimator.start();
			break;
		case R.id.bt_scaleXY:
			/* animator by xml
			AnimatorSet animatorSet = (AnimatorSet)AnimatorInflater.loadAnimator(this, R.animator.scalexy);
			animatorSet.setTarget(bt_scaleXY);
			*/
			//hard code the animation
			AnimatorSet scaleSet = new AnimatorSet();  
			scaleSet.playTogether(  
				ObjectAnimator.ofFloat(bt_scaleXY, "scaleX", 1, 1.5f),  
				ObjectAnimator.ofFloat(bt_scaleXY, "scaleY", 1, 1.5f),  
				ObjectAnimator.ofFloat(bt_scaleXY, "alpha", 1, 0.25f, 1)  
			);  
			scaleSet.setDuration(4 * 1000).start();
			break;
		case R.id.bt_translationX:
			objAnimator = (ObjectAnimator)AnimatorInflater.loadAnimator(this, R.animator.translationx);
			objAnimator.setTarget(bt_translationX);
			objAnimator.start();
			/*
			objAnimator = ObjectAnimator.ofFloat(bt_translationX, "translationX", 0f, 200f);
			objAnimator.setRepeatCount(1);
			objAnimator.setRepeatMode(ValueAnimator.REVERSE);
			objAnimator.setDuration(1000);
			objAnimator.start();
			*/
			break;
		case R.id.bt_translationY:
			objAnimator = ObjectAnimator.ofFloat(bt_translationY, "translationY", 0f, 200f);
			objAnimator.setRepeatCount(1);
			objAnimator.setRepeatMode(ValueAnimator.REVERSE);
			objAnimator.setDuration(1000);
			objAnimator.start();
			break;
		case R.id.bt_translationXY:
//          AnimatorSet translationSet = new AnimatorSet();  
//          translationSet.playTogether(  
//              ObjectAnimator.ofFloat(bt_translationXY, "translationX", 0, 200),  
//              ObjectAnimator.ofFloat(bt_translationXY, "translationY", 0, 200),  
//              ObjectAnimator.ofFloat(bt_translationXY, "alpha", 1, 0.25f, 1)  
//          );  
//          translationSet.setDuration(4000).start();  
              
            //另一种实现方式  
            PropertyValuesHolder pvhtranslationX = PropertyValuesHolder.ofFloat("translationX",0f,150f);  
            PropertyValuesHolder pvhtranslationY = PropertyValuesHolder.ofFloat("translationY",0f,150f);          
            objAnimator = ObjectAnimator.ofPropertyValuesHolder(bt_translationXY, pvhtranslationX,pvhtranslationY);  
              
            objAnimator.setRepeatCount(1);  
            objAnimator.setRepeatMode(ValueAnimator.REVERSE);  
            objAnimator.setDuration(2000);  
            objAnimator.start();
           break;
		case R.id.bt_rotationX:
			objAnimator = ObjectAnimator.ofFloat(bt_rotationX, "rotationX", 0f,300f);              
            objAnimator.setTarget(bt_rotationX);  
            objAnimator.setRepeatCount(1);  
            objAnimator.setRepeatMode(ValueAnimator.REVERSE);  
            objAnimator.setDuration(1000);              
            objAnimator.start();  
            break;
		case R.id.bt_rotationY:
			objAnimator = ObjectAnimator.ofFloat(bt_rotationY, "rotationY", 0f,300f);              
            objAnimator.setTarget(bt_rotationY);  
            objAnimator.setRepeatCount(1);  
            objAnimator.setRepeatMode(ValueAnimator.REVERSE);  
            objAnimator.setDuration(1000);              
            objAnimator.start();  
            break;
		case R.id.bt_rotation:
			AnimatorSet rotationSet = new AnimatorSet();  
            rotationSet.playTogether(  
                ObjectAnimator.ofFloat(bt_rotation, "rotationX", 0, 360),  
                ObjectAnimator.ofFloat(bt_rotation, "rotationY", 0, 360)  
            );  
//          rotationSet.playTogether(  
//                  ObjectAnimator.ofFloat(bt_rotation, "rotationX", 0, 360),  
//                  ObjectAnimator.ofFloat(bt_rotation, "rotationY", 0, 180),  
//                  ObjectAnimator.ofFloat(bt_rotation, "rotation", 0, -90)  
//                  );  
            rotationSet.setDuration(4 * 1000).start();  
            break; 
		case R.id.bt_x:  
            ObjectAnimator animX = ObjectAnimator.ofFloat(bt_x, "x", 50f);
              
            animX.setRepeatCount(1);  
            animX.setRepeatMode(ValueAnimator.REVERSE);  
            animX.setDuration(1000);  
              
            animX.start();  
            break;  
        case R.id.bt_y:  
            ObjectAnimator animY = ObjectAnimator.ofFloat(bt_y, "y", 100f);  
              
            animY.setRepeatCount(1);  
            animY.setRepeatMode(ValueAnimator.REVERSE);  
            animY.setDuration(1000);  
              
            animY.start();  
            break;  
        case R.id.bt_xy:  
              
            PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("x", 50f);  
            PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", 100f);  
            ObjectAnimator animXY = ObjectAnimator.ofPropertyValuesHolder(bt_xy, pvhX, pvhY);  
              
            animXY.setRepeatCount(1);  
            animXY.setRepeatMode(ValueAnimator.REVERSE);  
            animXY.setDuration(2000);              
            animXY.start();  
              
            //另一种方式 ViewPropertyAnimator  
//          bt_xy.animate().x(50f).y(100f).setDuration(2000).start();  
            break;
            
        case R.id.bt_vpa:

        	bt_vpa.animate().alpha(0.2f).rotation(480f).setDuration(2000)  
        	.setListener(new AnimatorListener() {  

        	@Override  
        	public void onAnimationStart(Animator animation) {  
        	// TODO Auto-generated method stub  
        	Log.e(TAG, "onAnimationStart");  
        	}  

        	@Override  
        	public void onAnimationRepeat(Animator animation) {  
        	// TODO Auto-generated method stub  
        	Log.e(TAG, "onAnimationRepeat");  
        	}  
        	@Override  
        	public void onAnimationEnd(Animator animation) {  
        	// TODO Auto-generated method stub  
        	Log.e(TAG, "onAnimationEnd");  
        	}  

        	@Override  
        	public void onAnimationCancel(Animator animation) {  
        	// TODO Auto-generated method stub  
        	Log.e(TAG, "onAnimationCancel");  
        	bt_vpa.animate().alpha(1f).rotation(240f).translationX(150).setDuration(2000).start();  
        	}  
        	})  
        	.start();  

        	break;

		default:
			break;
		}
	}	
}
