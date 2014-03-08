package com.klisly.zuijizhao.fragment;

import android.support.v4.app.Fragment;

import com.klisly.zuijizhao.ZuijzApplication;
import com.klisly.zuijizhao.ui.MenuContainerActivity;

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