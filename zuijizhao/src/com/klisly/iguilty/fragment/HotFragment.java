package com.klisly.iguilty.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.klisly.iguilty.IGuiltyApplication.AppBaseTask.OnCallBackListener;
import com.klisly.iguilty.R;
import com.klisly.iguilty.adapter.ListViewHotAdapter;
import com.klisly.iguilty.bean.GuiltyEntry;
import com.klisly.iguilty.task.GetGuiltyEntriesTask;
import com.klisly.iguilty.utils.UIHelper;

public class HotFragment extends BaseFragment implements OnClickListener {
	private ListViewHotAdapter mListViewHotAdapter;
	private PullToRefreshListView mHotListView;
	private List<GuiltyEntry> mGuiltyItems;

	public HotFragment() {
		super();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hot, null);

		v.findViewById(R.id.rl_btn_back).setOnClickListener(this);
		v.findViewById(R.id.ll_btn_release).setOnClickListener(this);

		mHotListView = (PullToRefreshListView) v
				.findViewById(R.id.pull_refresh_list);

		// Set a listener to be invoked when the list should be refreshed.

		mGuiltyItems = new ArrayList<GuiltyEntry>();
		for (int i = 0; i < 20; i++) {
			GuiltyEntry guiltyEntry = new GuiltyEntry();
			guiltyEntry.setAvatar("http://baidu.com/index.jpg");
			guiltyEntry.setContentAudio("http://baidu.com/audio.jpg");
			guiltyEntry.setContenText("这是一个测试算法");
			guiltyEntry.setContentImage("http://baidu.com/image.jpg");
			guiltyEntry.setGuiltyId("200012002");
			guiltyEntry.setNickname("iGuilty");
			guiltyEntry.setPraise(new Random().nextInt(1000));
			guiltyEntry.setUid("290099303");
			mGuiltyItems.add(guiltyEntry);
		}
		final GuiltyEntry guiltyEntry = new GuiltyEntry();
		guiltyEntry.setAvatar("http://baidu.com/index.jpg");
		guiltyEntry.setContentAudio("http://baidu.com/audio.jpg");
		guiltyEntry.setContenText("这是一个测试算法");
		guiltyEntry.setContentImage("http://baidu.com/image.jpg");
		guiltyEntry.setGuiltyId("200012002");
		guiltyEntry.setNickname("iGuilty");
		guiltyEntry.setPraise(new Random().nextInt(1000));
		guiltyEntry.setUid("290099303");
		mGuiltyItems.add(guiltyEntry);
		ListView mActualListView = mHotListView.getRefreshableView();
		mListViewHotAdapter = new ListViewHotAdapter(mContext, mGuiltyItems,
				R.layout.module_guilty_item);
		mActualListView.setAdapter(mListViewHotAdapter);
		mHotListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				String label = DateUtils.formatDateTime(HotFragment.this
						.getActivity().getApplicationContext(), System
						.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
						| DateUtils.FORMAT_SHOW_DATE
						| DateUtils.FORMAT_ABBREV_ALL);

				// Update the LastUpdatedLabel
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
				GetGuiltyEntriesTask mGetGuiltyEntriesTask = new GetGuiltyEntriesTask(
						label);
				mGetGuiltyEntriesTask
						.setOnCallBackListener(new OnCallBackListener() {

							@Override
							public void onCallBack(String result) {
								mGuiltyItems.add(0,guiltyEntry);
								System.out.println(mGuiltyItems.size());
								mListViewHotAdapter.notifyDataSetChanged();
								mHotListView.onRefreshComplete();
							}
						});
				mGetGuiltyEntriesTask.execute();
			}
		});

		
		// Add an end-of-list listener
		mHotListView
				.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

					@Override
					public void onLastItemVisible() {
						Toast.makeText(HotFragment.this.getActivity(),
								"End of List!", Toast.LENGTH_SHORT).show();
					}
				});
		//注册
		registerForContextMenu(mHotListView);
		// bindData();
		return v;
	}

	private void bindData() {
		List<GuiltyEntry> items = new ArrayList<GuiltyEntry>();
		for (int i = 0; i < 20; i++) {
			GuiltyEntry guiltyEntry = new GuiltyEntry();
			guiltyEntry.setAvatar("http://baidu.com/index.jpg");
			guiltyEntry.setContentAudio("http://baidu.com/audio.jpg");
			guiltyEntry.setContenText("这是一个测试算法");
			guiltyEntry.setContentImage("http://baidu.com/image.jpg");
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
		case R.id.rl_btn_back:
			mContext.toggle();
			break;
		case R.id.ll_btn_release:
			UIHelper.openReleaseActivity((Activity) this.getActivity());
			break;
		}
	}

}
