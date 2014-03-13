package com.klisly.iguilty.utils;

import android.app.Activity;
import android.content.Intent;

import com.klisly.iguilty.ui.ReleaseGuiltyActivity;
import com.klisly.iguilty.ui.SettingActivity;
import com.klisly.iguilty.ui.UserCenterActivity;

public class UIHelper {

	public static void openReleaseActivity(Activity activity) {
		Intent intent = new Intent(activity, ReleaseGuiltyActivity.class);
		activity.startActivity(intent);
	}
	
	public static void openUserCenterActivity(Activity activity) {
		Intent intent = new Intent(activity, UserCenterActivity.class);
		activity.startActivity(intent);
	}

	public static void openSettingActivity(Activity activity) {
		Intent intent = new Intent(activity, SettingActivity.class);
		activity.startActivity(intent);
	}
}
