package rdx.one.rdx;


/*
 * Author : Vijith Venkatesh
 * Andrew Id : vvankate
 * This activity is responsible to list the video files
 * available and starting a video player activity when
 * the play button is pressed
 * 
 */
import java.io.IOException;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class VideoActivity extends Activity {
	
	String player = new String();
	ArrayList<String> mp4files = new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		playVideo1Button();
		playVideo2Button();
		
		mp4files.add("gudugudiya_jam");
		mp4files.add("no_one_will");

		// Show list of mp3 files to user
		String s1 = getString(R.string.s1);
		String s2 = getString(R.string.s2);
		s1 = mp4files.get(0);
		s2 = mp4files.get(1);
		((TextView) findViewById(R.id.s1)).setText(s1);
		((TextView) findViewById(R.id.s2)).setText(s2);

	}
	
	/*
	 *This method is used to inistialise the play button for 1st video
	 *and call the method playMP4 to start playing the video 
	 */
	
	public void playVideo1Button() {
		Button button = (Button) findViewById(R.id.s1b);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				playMP4(mp4files.get(0));
			}
		});
	}
	
	
	/*
	 *This method is used to inistialise the play button for 2nd video
	 *and call the method playMP4 to start playing the video 
	 */
	public void playVideo2Button() {
		Button button = (Button) findViewById(R.id.s2b);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (player != null) 
				playMP4(mp4files.get(1));
			}
		});
	}
	
	/*
	 * This method is used to list all the files that are present
	 * in the folder
	 */
	
	public void listFiles(ArrayList<String> list, String dir) {
		Resources res = getResources(); 
		AssetManager am = res.getAssets();
		String fileList[] = null;
		try {
			fileList = am.list(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (fileList != null) {
			for (int i = 0; i < fileList.length; i++) {
				list.add(dir + "/" + fileList[i]);
			}
		}
	}

	/*
	 * This method is used to start the video player activity
	 * the intent carries the filename which has to 
	 * be played by the media player
	 * 
	 */
	private void playMP4(String filename) {
		Intent myIntent = new Intent(VideoActivity.this,VideosActivity.class);
        myIntent.putExtra("filename", filename);
		startActivity(myIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video, menu);
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
