package com.klisly.iguilty;

import java.io.File;

import android.annotation.SuppressLint;
import android.os.Environment;

/**
 * 应用程序配置类：用于保存用户相关信息及设置
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
@SuppressLint("NewApi")
public class AppConfig {
	public final static String APP_NAME = "iguilty";
	public final static String APP_CONFIG = "config";

	public final static String CONF_COOKIE = "cookie";
	public final static String CONF_LOAD_IMAGE = "perf_loadimage";
	public final static String DEFAULT_APP_PATH = Environment
			.getExternalStorageDirectory()
			+ File.separator
			+ APP_NAME
			+ File.separator;
	public final static String SAVE_IMAGE_PATH = DEFAULT_APP_PATH + "images";
	public final static String SAVE_AUDIO_PATH = DEFAULT_APP_PATH + "videos";

}
