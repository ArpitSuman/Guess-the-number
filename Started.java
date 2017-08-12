package com.example.guess;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Started extends MainActivity {
	EditText t1;
	TextView e1,e2;
	Button go,mute;
	int a,chance;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.started);
		t1=(EditText)findViewById(R.id.editText1);
		e1=(TextView)findViewById(R.id.textView1);
		e2=(TextView)findViewById(R.id.textView2);
		mute=(Button)findViewById(R.id.button2);
		go=(Button)findViewById(R.id.button1);
		Random r=new Random();
		a=r.nextInt(20);
		chance=5;
		System.out.println(a);
		e1.setText("Guess the number between 0 and 20.");
		e2.setText(Integer.toString(chance));
		//System.out.println(e1.getText().toString());
		go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
					String s;
					chance=Integer.parseInt(e2.getText().toString());
					chance--;
					try
					{
						s=t1.getText().toString();
						int g=Integer.parseInt(s);
						e2.setText(Integer.toString(chance));
						if(chance==0&&a!=g)
						{
							Intent i=new Intent(Started.this,YouLose.class);
							i.putExtra("m",Integer.toString(a));
							startActivity(i);
						}
						else if(chance!=0 && a!=g)
						{
							e2.setText(Integer.toString(chance));
							Toast.makeText(getApplicationContext(), "Wongly guessed!!!You have "+chance+" more attempts.", Toast.LENGTH_SHORT).show();
							
							t1.setText("");
						}
						else
						{
							Intent i=new Intent(Started.this,YouWin.class);
							i.putExtra("m",Integer.toString(a));
							startActivity(i);
						}	
					}
					catch(NullPointerException ex)
					{
						Toast.makeText(getApplicationContext(), "Number field can not be left blank.", Toast.LENGTH_LONG).show();
					}
					catch(NumberFormatException ex)
					{
						Toast.makeText(getApplicationContext(), "Number field can not be filled with a string.", Toast.LENGTH_LONG).show();
					}
			}});
		mute.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Started.this,MusicService.class);
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
