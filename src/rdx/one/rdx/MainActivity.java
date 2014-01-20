package rdx.one.rdx;

/*
 * Author : Vijith Venkatesh
 * Andrew Id : vvankate
 * This is the activity responsible for displaying the first
 * screen of the app
 * Here i have used multiple image buttons and their
 * corresponding listeners to make the transitions to different activities
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private ImageButton b1,b2,b3,b4,b5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(ImageButton)findViewById(R.id.imageButton1);
		b2=(ImageButton)findViewById(R.id.imageButton2);
		b3=(ImageButton)findViewById(R.id.imageButton3);
		b4=(ImageButton)findViewById(R.id.imageButton4);
		b5=(ImageButton)findViewById(R.id.imageButton5);
		
		
		b1.setOnClickListener(new OnClickListener() {
			@Override
			 public void onClick(View view) {
				Intent intent1 = new Intent(getBaseContext(),AudioActivity.class);
				startActivity(intent1);					
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			@Override
			 public void onClick(View view) {
				Intent intent2 = new Intent(getBaseContext(),VideoActivity.class);
				startActivity(intent2);					
			}
		});
	
		
		b3.setOnClickListener(new OnClickListener() {
			@Override
			 public void onClick(View view) {
				Intent intent3 = new Intent(getBaseContext(),GalleryActivity.class);
				startActivity(intent3);					
			}
		});
		
		b4.setOnClickListener(new OnClickListener() {
			@Override
			 public void onClick(View view) {
				Intent intent4 = new Intent(getBaseContext(),MailActivity.class);
				startActivity(intent4);					
			}
		});
		
		b5.setOnClickListener(new OnClickListener() {
			@Override
			 public void onClick(View view) {
				Intent intent5 = new Intent(getBaseContext(),ProfileActivity.class);
				startActivity(intent5);					
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onStart()
    {
        super.onStart();
    }
	
	@Override
    public void onRestart()  
    {
        super.onRestart();
    }
	
	@Override
    public void onResume()
    {
        super.onResume();
    }
	
	@Override
    public void onPause()
    {
        super.onPause();
    }
	
	@Override
    public void onStop()
    {
        super.onStop();
    }
	
	@Override
    public void onDestroy()
    {
		super.onDestroy();
        
    }

}
