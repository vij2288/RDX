package rdx.one.rdx;

/*
 * Author : Vijith Venkatesh
 * Andrew Id : vvankate
 * This activity is responsible to play the video
 * it uses videoHolder as the media controller to 
 * play the video
 * 
 */
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideosActivity extends Activity {

    VideoView videoview;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videos);
		
		videoview = (VideoView) findViewById(R.id.videoView);
		String filename = getIntent().getStringExtra("filename");
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
        VideoView videoHolder = new VideoView(this);
        videoHolder.setMediaController(new MediaController(this));
        Uri video = null;
        if (filename.equalsIgnoreCase("gudugudiya_jam"))
        	video = Uri.parse("android.resource://" + getPackageName() + "/" 
        			+ R.raw.gudugudiya_jam);
        else 
        	video = Uri.parse("android.resource://" + getPackageName() + "/" 
        	        + R.raw.no_one_will);
        videoHolder.setVideoURI(video);
        setContentView(videoHolder);
        videoHolder.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.videos, menu);
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
