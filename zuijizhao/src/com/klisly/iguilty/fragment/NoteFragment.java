package com.klisly.iguilty.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klisly.iguilty.R;

public class NoteFragment extends BaseFragment {

	
	
	public NoteFragment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_note, null);
		return v;
	}
	
	

}
