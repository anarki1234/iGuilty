package com.klisly.iguilty.fragment;

import android.support.v4.app.Fragment;

import com.klisly.iguilty.ZuijzApplication;
import com.klisly.iguilty.ui.MenuContainerActivity;

public abstract class BaseFragment extends Fragment {
	protected MenuContainerActivity mContext;
	protected ZuijzApplication mApplication;

	public BaseFragment() {
	}

	public BaseFragment(MenuContainerActivity context) {
		mContext = context;
		mApplication = (ZuijzApplication) mContext.getApplication();
	}

	public void setContext(MenuContainerActivity context) {
		mContext = context;
		mApplication = (ZuijzApplication) mContext.getApplication();
	}

}