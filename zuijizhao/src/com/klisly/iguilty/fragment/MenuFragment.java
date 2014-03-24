package com.klisly.iguilty.fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

import com.klisly.iguilty.R;
import com.klisly.iguilty.adapter.MenuListAdapter;
import com.klisly.iguilty.bean.MenuEntry;
import com.klisly.iguilty.bean.MenuEntry.State;
import com.klisly.iguilty.ui.MenuContainerActivity;
import com.klisly.iguilty.utils.UIHelper;

public class MenuFragment extends BaseFragment implements OnClickListener {
	private MenuListAdapter menuAdapter;
	private String[] menus;
	private ListView mMenuListView;
	private BaseFragment[] fragments = { new HotFragment(),
			new EliteFragment(), null, new CollectionFragment(),
			new JoinedHotFragment(), new ReleasedFragment(),
			new NoteFragment(), null, new CheckFragment() };

	public MenuFragment() {
		super();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_menu, null);
		v.findViewById(R.id.ll_btn_user).setOnClickListener(this);
		v.findViewById(R.id.rl_btn_setting).setOnClickListener(this);

		menus = this.getActivity().getResources().getStringArray(R.array.menus);
		ArrayList<MenuEntry> items = new ArrayList<MenuEntry>();
		for (int i = 0; i < menus.length; i++) {
			MenuEntry mMenuEntry = new MenuEntry();
			mMenuEntry.setName(menus[i]);
			if (i == 0)
				mMenuEntry.setState(State.CHECKED);
			else
				mMenuEntry.setState(State.UNCHECKED);
			if (fragments[i] != null)
				mMenuEntry.setFragment((BaseFragment) fragments[i]);
			else
				mMenuEntry.setFragment(null);
			items.add(mMenuEntry);
		}
		mMenuListView = (ListView) v.findViewById(R.id.menulist);
		menuAdapter = new MenuListAdapter(
				(MenuContainerActivity) this.getActivity(), items,
				R.layout.module_menu_item);
		mMenuListView.setAdapter(menuAdapter);

		return v;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.ll_btn_user:
			UIHelper.openUserCenterActivity((Activity)this.getActivity());
			break;
		case R.id.rl_btn_setting:
			UIHelper.openSettingActivity((Activity)this.getActivity());
			break;
		}

	}

}
