package com.klisly.iguilty;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Properties;

import android.app.Application;
import android.os.AsyncTask;

import com.klisly.iguilty.utils.StringUtils;

public class IGuiltyApplication extends Application {
	
	public static final int NETTYPE_WIFI = 0x01;
	public static final int NETTYPE_CMWAP = 0x02;
	public static final int NETTYPE_CMNET = 0x03;
	
	public static final int PAGE_SIZE = 20;//默认分页大小
	private static final int CACHE_TIME = 60*60000;//缓存失效时间
	
	private boolean login = false;	//登录状态
	private int loginUid = 0;	//登录用户的id
	private Hashtable<String, Object> memCacheRegion = new Hashtable<String, Object>();
	
	private String saveImagePath;//保存图片路径
	private IGuiltyQLiteOpenHelper mSqlHelper;
	
	@Override
	public void onCreate() {
		super.onCreate();
        //注册App异常崩溃处理器
        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
		mSqlHelper = new IGuiltyQLiteOpenHelper(this);
		AppBaseTask.setApplication(this);
        init();
	}

	/**
	 * 初始化
	 */
	private void init(){
		//设置保存图片的路径
		saveImagePath = getProperty(AppConfig.SAVE_IMAGE_PATH);
		if(StringUtils.isEmpty(saveImagePath)){
			setProperty(AppConfig.SAVE_IMAGE_PATH, AppConfig.DEFAULT_SAVE_IMAGE_PATH);
			saveImagePath = AppConfig.DEFAULT_SAVE_IMAGE_PATH;
		}
	}
	
	/**
	 * 保存对象
	 * @param ser
	 * @param file
	 * @throws IOException
	 */
	public boolean saveObject(Serializable ser, String file) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
			fos = openFileOutput(file, MODE_PRIVATE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ser);
			oos.flush();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				oos.close();
			} catch (Exception e) {}
			try {
				fos.close();
			} catch (Exception e) {}
		}
	}
	
	public boolean containsProperty(String key){
		Properties props = getProperties();
		 return props.containsKey(key);
	}
	
	public void setProperties(Properties ps){
		AppConfig.getAppConfig(this).set(ps);
	}

	public Properties getProperties(){
		return AppConfig.getAppConfig(this).get();
	}
	
	public void setProperty(String key,String value){
		AppConfig.getAppConfig(this).set(key, value);
	}
	
	public String getProperty(String key){
		return AppConfig.getAppConfig(this).get(key);
	}
	public void removeProperty(String...key){
		AppConfig.getAppConfig(this).remove(key);
	}

	/**
	 * 获取内存中保存图片的路径
	 * @return
	 */
	public String getSaveImagePath() {
		return saveImagePath;
	}
	/**
	 * 设置内存中保存图片的路径
	 * @return
	 */
	public void setSaveImagePath(String saveImagePath) {
		this.saveImagePath = saveImagePath;
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
