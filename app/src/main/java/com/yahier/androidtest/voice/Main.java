package com.yahier.androidtest.voice;

import java.io.IOException;


import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.yahier.androidtest.R;

/**
 * @author yahier
 *
 */
public class Main extends Activity {
	String path = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/yahier.aac";
	MediaRecorder recorder;
	MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.voice_recoder);
		
	}

	public void start(View view) {
		try {
			recorder = new MediaRecorder();
			recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			recorder.setOutputFile(path);
			recorder.prepare();
			recorder.start();
		} catch (IllegalStateException e) {
			System.out.println("1 is " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("2 is " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void stop(View view) {

		recorder.stop();
		recorder.reset();
		recorder.release();
		recorder = null;
	}

	public void play(View view) {
		try {
			player = new MediaPlayer();
			player.setDataSource(path);
			player.prepare();
			player.start();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
