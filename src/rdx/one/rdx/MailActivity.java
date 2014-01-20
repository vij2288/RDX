package rdx.one.rdx;

/*
 * Author: Vijith Venkatesh
 * Andrew ID : vvankate
 * 
 * This is the activity which is responsible to accept
 * user information and send a mail to the required email address
 * I have used Intent.Action_SEND to indicate the mail sending intent
 * Also the type is set to "message/rfc822" to indicate that it is MIME
 * Here i have used my personal id as the recipient, please change it 
 * while testing 
 * 
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailActivity extends Activity {

	private Button b1;
	private EditText et1,et2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail);
		b1=(Button)findViewById(R.id.button2);
		et1 = (EditText) findViewById(R.id.edit1);
		et2 = (EditText) findViewById(R.id.edit2);	
		b1.setOnClickListener(new OnClickListener() {
						
			@Override
			 public void onClick(View view) {
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"vij2288@gmail.com"});
				i.putExtra(Intent.EXTRA_SUBJECT, "Subscription");
				i.putExtra(Intent.EXTRA_TEXT   , et1.getText().toString()+" with email id "+et2.getText().toString());
				try {
				    startActivity(Intent.createChooser(i, "Send mail..."));
				} catch (android.content.ActivityNotFoundException ex) {
				    Toast.makeText(MailActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}
			}
		});	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mail, menu);
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
