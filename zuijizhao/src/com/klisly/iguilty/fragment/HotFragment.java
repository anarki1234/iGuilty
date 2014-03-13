package com.klisly.iguilty.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.klisly.iguilty.R;
import com.klisly.iguilty.adapter.ListViewHotAdapter;
import com.klisly.iguilty.bean.GuiltyEntry;
import com.klisly.iguilty.utils.UIHelper;

public class HotFragment extends BaseFragment implements OnClickListener {
	private ListViewHotAdapter mListViewHotAdapter;
	private ListView mHotListView;
	public HotFragment() {
		super();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hot, null);

		v.findViewById(R.id.ll_btn_back).setOnClickListener(this);
		v.findViewById(R.id.ll_btn_release).setOnClickListener(this);
		mHotListView = (ListView) v.findViewById(R.id.hotlist);
		
		List<GuiltyEntry> items = new ArrayList<GuiltyEntry>();
		for(int i = 0 ; i< 20 ; i ++){
			GuiltyEntry guiltyEntry= new GuiltyEntry();
			guiltyEntry.setAvatar("http://baidu.com/index.jpg");
			guiltyEntry.setContentAudio("http://baidu.com/audio.jpg");
			guiltyEntry.setContenText("这是一个测试算法");
			guiltyEntry.setContentImage( "http://baidu.com/image.jpg");
			guiltyEntry.setGuiltyId("200012002");
			guiltyEntry.setNickname("iGuilty");
			guiltyEntry.setPraise(new Random().nextInt(1000));
			guiltyEntry.setUid("290099303");
			items.add(guiltyEntry);
		}
		
		mListViewHotAdapter = new ListViewHotAdapter(mContext, items, R.layout.module_guilty_item);
		mHotListView.setAdapter(mListViewHotAdapter);
		
//		bindData();
		return v;
	}


	private void bindData() {
		List<GuiltyEntry> items = new ArrayList<GuiltyEntry>();
		for(int i = 0 ; i< 20 ; i ++){
			GuiltyEntry guiltyEntry= new GuiltyEntry();
			guiltyEntry.setAvatar("http://baidu.com/index.jpg");
			guiltyEntry.setContentAudio("http://baidu.com/audio.jpg");
			guiltyEntry.setContenText("这是一个测试算法");
			guiltyEntry.setContentImage( "http://baidu.com/image.jpg");
			guiltyEntry.setGuiltyId("200012002");
			guiltyEntry.setNickname("iGuilty");
			guiltyEntry.setPraise(new Random().nextInt(1000));
			guiltyEntry.setUid("290099303");
			items.add(guiltyEntry);
		}
		
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_btn_back:
			mContext.toggle();
			break;
		case R.id.ll_btn_release:
			UIHelper.openReleaseActivity((Activity)this.getActivity());
			break;
		}
	}
}
