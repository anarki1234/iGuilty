package com.klisly.iguilty.fragment;

import com.klisly.iguilty.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ReleasedFragment extends BaseFragment {

	
	
	public ReleasedFragment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_released, null);
		return v;
	}
	
	

}
