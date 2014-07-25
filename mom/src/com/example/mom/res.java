package com.example.mom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class res extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res);
		Button about1 = (Button)findViewById(R.id.about1);
	       about1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					try{
						Class ourClass = Class.forName("com.example.mom.about");
						Intent ourIntent = new Intent(res.this, ourClass );
						startActivity(ourIntent);
						}catch(ClassNotFoundException e){
							e.printStackTrace();
						}

					
				}
			});
		
	} 
	
		 
}
