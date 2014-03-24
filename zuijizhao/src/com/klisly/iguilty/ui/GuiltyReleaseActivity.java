package com.klisly.iguilty.ui;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.klisly.iguilty.IGuiltyApplication;
import com.klisly.iguilty.R;
import com.klisly.iguilty.utils.FileUtils;
import com.klisly.iguilty.utils.ImagesUtils;
import com.klisly.iguilty.utils.MetricUtils;

public class GuiltyReleaseActivity extends Activity implements OnClickListener {
	private String TAG = "GuiltyReleaseActivity";
	private static final int CAMERA_RESULT = 0;
	private static final int ALBUM_RESULT = 1;
	private IGuiltyApplication mApplication;
	private RelativeLayout mRlBtnBack;
	private RelativeLayout mRlBtnRelease;
	private RelativeLayout mRlBtnAlbum;
	private RelativeLayout mRlBtnCamera;
	private EditText mEtContent;
	private ImageView mIvPicture;

	private String mContent = "";
	private String mImgPath = "";
	private String mAudioPath = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
						| WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		setContentView(R.layout.activity_guilty_release);
		mApplication = (IGuiltyApplication) this.getApplication();
		mRlBtnBack = (RelativeLayout) findViewById(R.id.rl_btn_back);
		mRlBtnBack.setOnClickListener(this);
		mRlBtnRelease = (RelativeLayout) findViewById(R.id.rl_btn_release);
		mRlBtnRelease.setOnClickListener(this);
		mRlBtnAlbum = (RelativeLayout) findViewById(R.id.rl_btn_album);
		mRlBtnAlbum.setOnClickListener(this);
		mRlBtnCamera = (RelativeLayout) findViewById(R.id.rl_btn_camera);
		mRlBtnCamera.setOnClickListener(this);
		mEtContent = (EditText) findViewById(R.id.et_guilty_content);
		mIvPicture = (ImageView) findViewById(R.id.iv_guilty_picture);
		refreshUI();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		Intent i;
		switch (id) {
		case R.id.rl_btn_back:
			onBackPressed();
			break;
		case R.id.rl_btn_release:
			mContent = mEtContent.getText().toString();
			mAudioPath = "";

			break;
		case R.id.rl_btn_camera:
			File file = FileUtils.createFile(this,
					mApplication.getSaveImagePath(),
					FileUtils.getOutputMediaFile(FileUtils.MEDIA_TYPE_IMAGE));
			mImgPath = file.getPath();
			Uri imageFileUri = Uri.fromFile(file);
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			i.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageFileUri);
			startActivityForResult(i, CAMERA_RESULT);
			break;
		case R.id.rl_btn_album:
			i = new Intent(
					Intent.ACTION_PICK,
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(i, ALBUM_RESULT);
			break;
		case R.id.iv_guilty_picture:
			
			
			break;
		}

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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			if (requestCode == CAMERA_RESULT) {
				Log.i(TAG, "camera_result");
				mIvPicture.setImageBitmap(ImagesUtils.getImageThumbnail(
						mImgPath, MetricUtils.dip2px(this, 50),
						MetricUtils.dip2px(this, 50)));
				refreshUI();
			} else if (requestCode == ALBUM_RESULT) {
				Log.i(TAG, "album_result");
				Uri uri = data.getData();
				mImgPath = FileUtils.getImagePathFromURI(this, uri);
				mIvPicture.setImageBitmap(ImagesUtils.getImageThumbnail(
						mImgPath, MetricUtils.dip2px(this, 50),
						MetricUtils.dip2px(this, 50)));
				refreshUI();
			}
		}
	}

	private void refreshUI() {
		if (!mImgPath.isEmpty()) {
			mRlBtnAlbum.setVisibility(View.GONE);
			mRlBtnCamera.setVisibility(View.GONE);
			mIvPicture.setVisibility(View.VISIBLE);
		} else {
			mRlBtnAlbum.setVisibility(View.VISIBLE);
			mRlBtnCamera.setVisibility(View.VISIBLE);
			mIvPicture.setVisibility(View.GONE);
		}

	}


}
