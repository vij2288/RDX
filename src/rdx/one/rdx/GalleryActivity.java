package rdx.one.rdx;

/*
 * Author: Vijith Venkatesh
 * Andrew ID: vvankate
 * 
 * This activity is responsible to render the gallery of photos
 * I have also added a button which will redirect the user to 
 * the artist's online image gallery
 * 
 */

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class GalleryActivity extends Activity {

	private Button b1;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			 public void onClick(View view) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/photo.php?" +
						"fbid=10152642244382137&set=pb.22220507136.-2207520000.1384328282.&type=3&theater"));
				startActivity(browserIntent);
			}
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallery, menu);
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
