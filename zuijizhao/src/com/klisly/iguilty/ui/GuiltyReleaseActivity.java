package com.klisly.iguilty.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.klisly.iguilty.R;

public class GuiltyReleaseActivity extends Activity implements OnClickListener {
	private RelativeLayout mRlBtnBack;
	private RelativeLayout mRlBtnRelease;
	private RelativeLayout mRlBtnAlbum;
	private RelativeLayout mRlBtnCamera;
	private EditText mEtContent;
	private ImageView mIvPicture;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guilty_release);
		mRlBtnBack = (RelativeLayout) findViewById(R.id.rl_btn_back);
		mRlBtnBack.setOnClickListener(this);
		mRlBtnRelease = (RelativeLayout) findViewById(R.id.rl_btn_release);
		mRlBtnRelease.setOnClickListener(this);
		mRlBtnAlbum = (RelativeLayout) findViewById(R.id.rl_btn_album);
		mRlBtnAlbum.setOnClickListener(this);;
		mRlBtnCamera = (RelativeLayout) findViewById(R.id.rl_btn_camera);
		mRlBtnCamera.setOnClickListener(this);
		mEtContent = (EditText) findViewById(R.id.et_guilty_content);
		mIvPicture = (ImageView) findViewById(R.id.iv_guilty_picture);
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				inputManager.toggleSoftInput(0,
						InputMethodManager.HIDE_NOT_ALWAYS);
			}
		}, 200);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
