package com.klisly.iguilty.ui;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.klisly.iguilty.IGuiltyApplication;
import com.klisly.iguilty.fragment.BaseFragment;
import com.klisly.iguilty.fragment.HotFragment;
import com.klisly.iguilty.fragment.MenuFragment;
import com.klisly.iguilty.R;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;


public class BaseSlidingActivity extends BaseActivity {
	
	protected MenuFragment mFrag;
	
	public BaseSlidingActivity() {
		super();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Behind View
		setBehindContentView(R.layout.frame_menu);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager()
					.beginTransaction();
			mFrag = new MenuFragment();
			t.replace(R.id.fragment_menu_container, mFrag);
			t.commit();
		} else {
			mFrag = (MenuFragment) this.getSupportFragmentManager()
					.findFragmentById(R.id.fragment_menu_container);
		}

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

	}
	
	public void switchFragment(BaseFragment targetFragment) {
		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();

		t.replace(R.id.fragment_container, targetFragment);
		t.commit();
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			@Override
			public void run() {
				getSlidingMenu().showContent();
			}
		}, 50);
	}
}
