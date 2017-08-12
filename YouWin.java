package com.example.guess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class YouWin extends MainActivity {
	Button play,mute;
	TextView e;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.win);
		play=(Button)findViewById(R.id.button1);
		mute=(Button)findViewById(R.id.button2);
		e=(TextView)findViewById(R.id.textView1);
		String data=getIntent().getExtras().getString("m");
		data="Generated number was:"+data;
		e.setText(data);
		play.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(YouWin.this,MainActivity.class);
				startActivity(i);
				}
		});
		mute.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(YouWin.this,MusicService.class);
				if(flag==false)
				{
					flag=true;
					startService(i);
				}
				else
				{
					flag=false;
					stopService(i);
				}
			}
		});
	}
	

}
