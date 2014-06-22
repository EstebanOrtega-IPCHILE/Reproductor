package example.reproductor;

import java.util.Timer;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	MediaPlayer mep;
	Button btnOn;
	
	int pos;
	private TextView tvPos;
	private Runnable r;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvPos = (TextView) findViewById(R.id.tvPos);
		
		//continuar(btnOn);
		
		iniciar();
		
	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public void destruir() {
		if (mep != null) {
			mep.release();
		}
	}

	public void play(View v) {

		destruir();

		mep = MediaPlayer.create(this, R.raw.tv);
		
		mep.start();
		
	}
	
	public void iniciar() {
		
        
		Timer timer = new Timer();
		
		TimerTask ttask = new TimerTask() {
			
			@Override
			public void run() {
				if (mep != null) {
					if(mep.isPlaying())
					{
						if(mep.getCurrentPosition()==21656){
							mep.pause();
							
							Intent i = new Intent(MainActivity.this, uno.class);
							startActivity(i);
						}
						
						if(mep.getCurrentPosition()==32052){
							mep.pause();
							Intent e = new Intent(MainActivity.this, dos.class);
							startActivity(e);
						}
						if(mep.getCurrentPosition()==40673){
							mep.pause();
							Intent o = new Intent(MainActivity.this, tres.class);
							startActivity(o);
						}
						if(mep.getCurrentPosition()==57339){
							mep.pause();
							Intent u = new Intent(MainActivity.this, cuatro.class);
							startActivity(u);
						}
						if(mep.getCurrentPosition()==84376){
							mep.pause();
							Intent a = new Intent(MainActivity.this, cinco.class);
							startActivity(a);
						}
					}
				}
			}
		};
		timer.scheduleAtFixedRate(ttask, 0, 100);
	}

	public void pausa(View v) {

		if (mep != null && mep.isPlaying()) {
			pos = mep.getCurrentPosition();
			String p = String.valueOf(pos);
			tvPos.setText(p);
			mep.pause();
			
		}

	}

	public void continuar(View v) {

		if (mep != null && mep.isPlaying() == false) {
			mep.seekTo(pos);

			mep.start();
		}

	}

	public void detener(View v) {

		if (mep != null) {
			mep.stop();
			pos = 0;
		}

	}

	public void Loop(View v) {
		String texto = btnOn.getText().toString();

		if (texto.equals("No Loop")) {
			btnOn.setText("Loop");
		} else {
			btnOn.setText("No Loop");
		}
	}

}
