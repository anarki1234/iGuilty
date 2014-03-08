package com.klisly.zuijizhao.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.klisly.zuijizhao.R;

public class HotFragment extends BaseFragment implements OnClickListener {
	public HotFragment() {
		super();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hot, null);

		v.findViewById(R.id.btn_back).setOnClickListener(this);
		v.findViewById(R.id.btn_release).setOnClickListener(this);
		return v;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
//			this.mContext.toggle();
			break;
		case R.id.btn_release:
			break;
		}
	}
}
