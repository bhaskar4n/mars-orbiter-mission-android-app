package com.example.mom;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.os.Build;








import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	    public int one;
	    double[] mdata = new mom_data1().light_time;
	    double[] mdata1 = new mom_data1().velocity1;
	    double[] mdata2 = new mom_data1().velocity2;
	    double[] mdata3 = new mom_data1().marslight;
	    double[] mdata4 = new mom_data1().marsv;
	    double[] mdata5 = new mom_data1().sunlight;
	    
	public TextView count,distance;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		Button about = (Button)findViewById(R.id.about);
       about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
					Class ourClass = Class.forName("com.example.mom.about");
					Intent ourIntent = new Intent(MainActivity.this, ourClass );
					startActivity(ourIntent);
					}catch(ClassNotFoundException e){
						e.printStackTrace();
					}

				
			}
		});
		
		
		 Date date = new Date(114,8,24);
    	final Date date1 = new Date();
   	    long dtMili = System.currentTimeMillis();
   	    Date dateNow = new Date(dtMili);
   	    long remain = date.getTime() - dateNow.getTime();
   	   
   	    try{
   	    
   	    new CountDownTimer(remain, 1) {

	     public void onTick(long millisUntilFinished) {
	    	 Calendar c1 = Calendar.getInstance();
	    	 SimpleDateFormat sdf1 = new SimpleDateFormat("h:m:s a");
	 		String strdate1 = sdf1.format(c1.getTime());
	 		TextView txtdate1 = (TextView) findViewById(R.id.textView1);
			txtdate1.setText(" "+date1);
		 ////////////////////////////////////////////////////
	    	 count  = (TextView)findViewById(R.id.count);
	     // converting secs to days,hrs,mins,secs format
	    	 float sec  = (millisUntilFinished/1000);
	    	 double minuites = sec/60;
	    	 double hrs = minuites/60;
	    	 double days = hrs/24;
	    	 double test = Math.floor(days);
	    	 double minus_hr = days - test;
	    	 double new_hr = minus_hr*24;
	    	 double test1= Math.floor(new_hr);
	    	 double minus_min = new_hr - test1;
	    	 double new_min = minus_min*60;
	    	 double test2 = (float) Math.floor(new_min);
	    	 double minus_sec = new_min - test2;
	    	 double new_sec = minus_sec*60;
	    	 
	    	 //rounding the time
	    	 int day = (int) Math.floor(days);
	    	 int hours = (int) Math.floor(new_hr);
	    	 int mini = (int) Math.floor(new_min);
	    	 int seconds = (int) Math.floor(new_sec);
	    	 count.setText(" "+day+" days: "+ hours+" hrs: "+mini+" mins: "+seconds+" secs");
	    	 int total_days = 298;
	    	 int current_day = total_days - day;
	    	 double total_seconds = total_days*24*3600;
	    	 double add_day = total_seconds - sec;
	    	 double total_distance = add_day*26.4;
	    	 int total = (int)Math.floor(total_distance);
	    	 TextView distance = (TextView)findViewById(R.id.distance);
	    	 distance.setText(" "+total+" km");
	    	 
	    	 
	    	
	    	 //if (days==0 && hours==0 && mini==0 && seconds==0){
	    		 	
	    		 	double one_way = mdata[current_day-1];
	    		 	float one_way_light = (float) ((one_way*60)*3e5);
	    		 	 int one= (int) Math.floor(one_way_light);
	    		 	TextView distance1 = (TextView)findViewById(R.id.distance1);
	    		 	double velocity2 = mdata2[current_day-1];
	   	    	
	   	    	TextView lighttime = (TextView)findViewById(R.id.lighttime);
	   	    	float one_way_light1 = (float) (one_way*60);
	   	    	int time = (int) Math.floor(one_way);
	   	    	lighttime.setText(one_way+" min");
	   	    	
	   	    	
	   	     distance1.setText(" "+one+"km, "+velocity2+"km/s");
	   	     
	   	     // relative to mars
	   	     double mars_one_way = mdata3[current_day-1];
	   	     double mars_distance = (mars_one_way*60)*3e5;
	   	     int mars_one= (int) Math.floor(mars_distance);
	   	     TextView mars = (TextView)findViewById(R.id.mars);
	   	     double marsv = mdata4[current_day-1];
	   	     mars.setText(" "+mars_one+"km, "+marsv+"km/s");
	   	     
	   	     // relative to sun
	   	     double sun_one_way = mdata5[current_day-1];
	   	     double sun_distance = (sun_one_way*60)*3e5;
	   	     int sun_one = (int)Math.floor(sun_distance);
	   	     TextView sun = (TextView)findViewById(R.id.sun);
	   	     double velocity1 = mdata1[current_day-1];
	   	     sun.setText(" "+sun_one+"km ,"+velocity1+"km/s");
		    	
	    		 	
	    	// }
	    	 
	   	     // adding roboto font
	   	  Typeface custom_font5 = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");
	      sun.setTypeface(custom_font5);
	      mars.setTypeface(custom_font5);
	      distance1.setTypeface(custom_font5);
	      distance.setTypeface(custom_font5);
	      lighttime.setTypeface(custom_font5);
	      txtdate1.setTypeface(custom_font5);
	      count.setTypeface(custom_font5);
	      
	      TextView txtdate = (TextView)findViewById(R.id.txtdate);
	      TextView a = (TextView)findViewById(R.id.a);
	      TextView b = (TextView)findViewById(R.id.b);
	      TextView d = (TextView)findViewById(R.id.d);
	      TextView e = (TextView)findViewById(R.id.e);
	      TextView f = (TextView)findViewById(R.id.f);
	      TextView c = (TextView)findViewById(R.id.c);
	      TextView orbit = (TextView)findViewById(R.id.orbit);
	      
	      Typeface custom_font6 = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf");
	      txtdate.setTypeface(custom_font6);
	      a.setTypeface(custom_font6);
	      b.setTypeface(custom_font6);
	      c.setTypeface(custom_font6);
	      d.setTypeface(custom_font6);
	      e.setTypeface(custom_font6);
	      orbit.setTypeface(custom_font5);
	     }

	     public void onFinish() {
	         count.setText("done!");
	     }
	  }.start();
	  
	  
   	    }catch(Exception e){
   	    	e.printStackTrace();
   	    	try{
				Class ourClass = Class.forName("com.example.mom.res");
				Intent ourIntent = new Intent(MainActivity.this, ourClass );
				startActivity(ourIntent);
				}catch(ClassNotFoundException e1){
					e1.printStackTrace();
				}

			
		}
	
   	    }
	 
	
		
		
	}
	//}




