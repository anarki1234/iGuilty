package com.klisly.iguilty;

import android.app.Application;
import android.os.AsyncTask;

import com.klisly.iguilty.utils.PreferencesUtils;
import com.klisly.iguilty.utils.StringUtils;

public class IGuiltyApplication extends Application {
	
	public static final int NETTYPE_WIFI = 0x01;
	public static final int NETTYPE_CMWAP = 0x02;
	public static final int NETTYPE_CMNET = 0x03;
	
	public static final int PAGE_SIZE = 20;//默认分页大小
	private static final int CACHE_TIME = 60*60000;//缓存失效时间
	
	private boolean login = false;	//登录状态
	private int loginUid = 0;	//登录用户的id
	
	private IGuiltyQLiteOpenHelper mSqlHelper;
	
	@Override
	public void onCreate() {
		super.onCreate();
        //注册App异常崩溃处理器
        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
		mSqlHelper = new IGuiltyQLiteOpenHelper(this);
		AppBaseTask.setApplication(this);
	}
	
	//保存图片路径
	public String getSaveImagePath() {
		String value = PreferencesUtils.getStringPreference(this, AppConfig.APP_NAME, "imagepath", "");
		if(StringUtils.isEmpty(value)){
			PreferencesUtils.setStringPreferences(this, AppConfig.APP_NAME, "imagepath", AppConfig.SAVE_IMAGE_PATH);
			value =  AppConfig.SAVE_IMAGE_PATH;
		}
		return value;
	}

	public void setSaveImagePath(String saveImagePath) {
		PreferencesUtils.setStringPreferences(this, AppConfig.APP_NAME, "imagepath", AppConfig.SAVE_IMAGE_PATH);
	}

	public IGuiltyQLiteOpenHelper getSqlHelper() {
		return mSqlHelper;
	}

	public void setSqlHelper(IGuiltyQLiteOpenHelper sqlHelper) {
		mSqlHelper = sqlHelper;
	}
	
	
	public static class AppBaseTask extends AsyncTask<String, Integer, String> {
		protected OnCallBackListener mOnCallBackListener;
		protected static IGuiltyApplication mApplication = null;
		protected static IGuiltyQLiteOpenHelper mSqlHelper = null;
		
		@Override
		protected String doInBackground(String... params) {
			//
			
			return null;
		}
		
		public AppBaseTask() {
		}
		
 		public AppBaseTask(OnCallBackListener onCallBackListener) {
			mOnCallBackListener = onCallBackListener;
		}
		public static interface OnCallBackListener {
			void onCallBack(String result);
		}

		public void setOnCallBackListener(OnCallBackListener listener) {
			mOnCallBackListener = listener;
		}

		public static void setApplication(IGuiltyApplication application) {
			mApplication = application;
			mSqlHelper = mApplication.getSqlHelper();
		}

		@Override
		protected void onPostExecute(String result) {
			if(mOnCallBackListener != null) {
				mOnCallBackListener.onCallBack(result);
			}
		}
	}
	
}
