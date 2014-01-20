package rdx.one.rdx;

/*
 * Author : Vijith Venkatesh
 * Andrew Id : vvankate
 * This is the activity which displays the public profile of the artist
 * I have used the Intent.Action_VIEW and URI perser to go to the facebook profile of the artist
 * Also i have used the Android:clickable and Android:autolink in the XML to redirect to the website  
 * 
 */

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ProfileActivity extends Activity {

	private ImageButton b1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		b1=(ImageButton)findViewById(R.id.imageButton6);
		
		b1.setOnClickListener(new OnClickListener() {
			@Override
			 public void onClick(View view) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/theraghudixitproject"));
				startActivity(browserIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
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
