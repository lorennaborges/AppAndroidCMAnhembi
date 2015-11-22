package com.dlp.scarysounds2.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.dlp.scarysounds2.R;
import com.dlp.scarysounds2.Util;
import com.dlp.scarysounds2.adapter.ImageAdapter;

public class MainActivity extends Activity {

//	private static String TAG = MainActivity.class.getSimpleName();
	// Declarando um MediaPlayer
	MediaPlayer m;
	// The space threshold expressed in dp
	private static final float SPACE_DP = 5.0f;
	// array de inteiros com imagens
	private int[] soundsIMG = new int[10];
	private int[] sounds = new int[10];
	GridView g;

	public int[] soundsImage() {
        for (int i = 0; i <= 9; i++) {
            soundsIMG[i] = R.mipmap.scream_fig;
        }
		return soundsIMG;
	}
	public int[] soundsRaw() {
		sounds[0] = R.raw.agony_scream;
		sounds[1] = R.raw.extreme_female_scream;
		sounds[2] = R.raw.girl_scream;
		sounds[3] = R.raw.hight_pitched_aaah;
		sounds[4] = R.raw.long_torture_scream;
		sounds[5] = R.raw.loud_reverb;
		sounds[6] = R.raw.manygirls_scream;
		sounds[7] = R.raw.panic_scream;
		sounds[8] = R.raw.short_intense_scream;
		sounds[9] = R.raw.woman_horror_scream;
		return sounds;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// capturando GridView pelo id
		g = (GridView) findViewById(R.id.gridView);
		DisplayMetrics dm = Util.getDisplayMetrics(this);
		int params = dm.widthPixels/2;
		final float scale = getResources().getDisplayMetrics().density;
		int pixelSpacing = (int) (SPACE_DP * scale + 0.5f);
		// setando configuracoes
		params = params-(pixelSpacing*2);
        ImageAdapter adapter = new ImageAdapter(MainActivity.this, soundsImage() , params, soundsRaw());
		g.setAdapter(adapter);
		
		// evento de click
		g.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
               // Log.i("Position:",  ""+position);
//				int tempInt = position+1;
				m = MediaPlayer.create(parent.getContext(), soundsRaw()[position]);
				try{
					m.prepare();
				} catch (Exception e) {
					Log.getStackTraceString(e);
				}
				m.start();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
			case R.id.menu_sobre:
				Intent intent = new Intent(MainActivity.this, SobreActivity.class);
				startActivity(intent);
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}


}
