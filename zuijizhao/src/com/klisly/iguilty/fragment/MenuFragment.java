package com.klisly.iguilty.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.klisly.iguilty.R;
import com.klisly.iguilty.adapter.MenuListAdapter;
import com.klisly.iguilty.bean.MenuEntry;
import com.klisly.iguilty.bean.MenuEntry.State;
import com.klisly.iguilty.ui.MenuContainerActivity;

public class MenuFragment extends BaseFragment {
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
		View v = inflater.inflate(R.layout.module_menu_scroll_view, null);
		menus = this.getActivity().getResources().getStringArray(R.array.menus);
		ArrayList<MenuEntry> items = new ArrayList<MenuEntry>();
		for (int i = 0; i < menus.length; i++) {
			MenuEntry mMenuEntry = new MenuEntry();
			mMenuEntry.setName(menus[i]);
			mMenuEntry.setState(State.UNCHECKED);
			if (fragments[i] != null)
				mMenuEntry.setFragment((BaseFragment) fragments[i]);
			else
				mMenuEntry.setFragment(null);
			items.add(mMenuEntry);
		}
		mMenuListView = (ListView) v.findViewById(R.id.menulist);
		menuAdapter = new MenuListAdapter((MenuContainerActivity)this.getActivity(), items,
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


}
