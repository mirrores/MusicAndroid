package com.example.musicandroid;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private ImageButton play,pause,stop;
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		play=(ImageButton)findViewById(R.id.play);
		pause=(ImageButton)findViewById(R.id.pause);
		stop=(ImageButton)findViewById(R.id.stop);
		
		
		play.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.start();
				play.setEnabled(false);
				pause.setEnabled(true);
				stop.setEnabled(true);
			}
			
		});
		pause.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				mp.pause();
				play.setEnabled(true);
				pause.setEnabled(false);
				stop.setEnabled(true);
			}
		});
		
		
		stop.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				mp.stop();
				play.setEnabled(true);
				pause.setEnabled(false);
				stop.setEnabled(false);
				
				try {
					mp.prepare();
					mp.seekTo(0);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
		});
		
		setup();
	}	
	public void setup() {
		// TODO Auto-generated method stub
		mp=MediaPlayer.create(this,R.raw.yinhun);
		play.setEnabled(true);
		pause.setEnabled(false);
		stop.setEnabled(false);
	}
	public void onCompletion(MediaPlayer mp){
		mp.stop();
	}
	public void onDestroy(){
		super.onDestroy();
		if(stop.isEnabled()){
			mp.stop();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
