package com.klisly.iguilty.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.klisly.iguilty.fragment.BaseFragment;
import com.klisly.iguilty.fragment.HotFragment;
import com.klisly.iguilty.fragment.MenuFragment;
import com.klisly.iguilty.R;
public class MenuContainerActivity extends BaseSlidingActivity {

	private BaseFragment mContent;

	public MenuContainerActivity() {
		super();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		if (savedInstanceState != null)
			mContent = (BaseFragment) getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
		if (mContent == null) {
			mContent = new HotFragment();
			mContent.setContext(this);
		}

		// set the Above View
		setContentView(R.layout.activity_container);

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, mContent).commit();

		// set the Behind View
		setBehindContentView(R.layout.fragment_menu);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_menu_container, new MenuFragment())
				.commit();

		// customize the SlidingMenu
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}

	public void switchContent(BaseFragment fragment) {
		mContent = fragment;
		fragment.setContext(this);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, fragment).commit();
		getSlidingMenu().showContent();
	}

	@Override
	public void toggle() {
		super.toggle();
	}
}
