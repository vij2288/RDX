package rdx.one.rdx;

/*
 * Author: Vijith Venkatesh
 * Andrew ID: vvankate
 * This activity is responsible for the mp3 player
 * I have used Mediaplayer class to instantiate a media player
 * defined 4 methods to carry out 4 different tasks
 * They are described below
 * 
 */
import java.io.IOException;
import java.util.ArrayList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AudioActivity extends Activity {
	
	private MediaPlayer player = new MediaPlayer();
	private int playbackPosition = 0;
	ArrayList<String> mp3files = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_audio);
		
		playSong1Button();
		playSong2Button();
		
		Button stopBtn = (Button) findViewById(R.id.Stop);
		Button pauseBtn = (Button) findViewById(R.id.Pause);
		Button resumeBtn = (Button) findViewById(R.id.Resume);

		pauseBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (player != null) {
					playbackPosition = player.getCurrentPosition();
					player.pause();
				}
			}
		});
		
		resumeBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (player != null && !player.isPlaying()) {
					player.seekTo(playbackPosition);
					player.start();
				}
			}
		});
		
		stopBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				try {
					player.stop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		listFiles(mp3files, "Audio");
		String s1 = getString(R.string.s1);
		String s2 = getString(R.string.s2);
		s1 = mp3files.get(0);
		s2 = mp3files.get(1);
		((TextView) findViewById(R.id.s1)).setText(s1);
		((TextView) findViewById(R.id.s2)).setText(s2);	
		
	}
	
	/*
	 * This method is used to list the audio files and added to
	 * the string arraylist which passed as the argument
	 */

	public void listFiles(ArrayList<String> list, String dir) {
		Log.d("TRACE", "listFiles(): Files in " + dir);
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
				list.add(dir + "/" +fileList[i]);
				Log.d("", fileList[i]);
			}
		}
	}
	
	/*
	 * This method is responsible to play the first song
	 * by calling another method and passing the song1
	 * as the argument for that method
	 */
	public void playSong1Button() {
		Button button = (Button) findViewById(R.id.s1b);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (player != null) {
					player.stop();			
				}
					playMP3(mp3files.get(0));
					playMP3(mp3files.get(0));								
			}
			
		});
	}
	
	/*
	 * This method is used to play the second song
	 * by calling another method and passing song2 as
	 * the argument for that method
	 * 
	 */
	public void playSong2Button() {
		Button button = (Button) findViewById(R.id.s2b);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (player != null) {
						player.stop();
				}
				playMP3(mp3files.get(1));
				playMP3(mp3files.get(1));
			}
		});
	}
	
	
	/*
	 * This method is called by the previous two 
	 * this method prepares the mediaplayer and starts 
	 * the mediaplayer by opening the file that was 
	 * passed as the argument
	 */
	private void playMP3(String filename) {
		AssetFileDescriptor afd = null;
		if (player == null)
			player = new MediaPlayer();
		try {
			afd = getAssets().openFd(filename);
			player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),
					afd.getLength());
			player.prepare();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		player.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.audio, menu);
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
		player.stop();
        
    }


}
