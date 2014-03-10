package com.klisly.iguilty.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.klisly.iguilty.ui.MenuContainerActivity;
import com.klisly.zuijizhao.R;

public class MenuFragment extends BaseFragment {
	private MenuListAdapter menuAdapter;
	private String[] menus;
	private ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
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
		View v = inflater.inflate(R.layout.layout_menu_scroll_view, null);
		menus = this.getActivity().getResources().getStringArray(R.array.menus);
		for (String menu : menus) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("itemname", menu);
			items.add(item);
		}

		mMenuListView = (ListView) v.findViewById(R.id.menulist);
		menuAdapter = new MenuListAdapter(this.getActivity());
		mMenuListView.setAdapter(menuAdapter);
		mMenuListView.setVisibility(View.VISIBLE);
		return v;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
		menuAdapter.notifyDataSetChanged();
	}

	// the meat of switching the above fragment
	private void switchFragment(BaseFragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof MenuContainerActivity) {
			MenuContainerActivity mca = (MenuContainerActivity) getActivity();
			mca.switchContent(fragment);
		}
	}

	class MenuListAdapter extends BaseAdapter {
		private Context mContext;

		public MenuListAdapter(Context context) {
			mContext = context;
		}

		public int getCount() {
			return menus.length;
		}

		@Override
		public boolean areAllItemsEnabled() {
			return false;
		}

		public Object getItem(int position) {
			return menus[position];
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, View convertView,
				ViewGroup parent) {
			Log.e("MenuFragent", "menu Adapter");
			TextView menuText = null;
			if (convertView == null) {
				if (!menus[position].equals("seperate")) {
					convertView = LayoutInflater.from(mContext).inflate(
							R.layout.layout_menu_list_item, null);
					menuText = (TextView) convertView
							.findViewById(R.id.menuText);
					convertView.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							switchFragment(fragments[position]);
						}
					});
				} else {
					convertView = new View(mContext);
					convertView.setBackgroundResource(R.drawable.menu_bg);
					ListView.LayoutParams rlParams = new ListView.LayoutParams(
							ListView.LayoutParams.MATCH_PARENT, 10);
					convertView.setLayoutParams(rlParams);
					convertView.setFocusable(false);
				}
			} else {
				if (!menus[position].equals("seperate")) {
					menuText = (TextView) convertView
							.findViewById(R.id.menuText);
					convertView.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							switchFragment(fragments[position]);
						}
					});
					convertView
							.setBackgroundResource(R.drawable.side_menu_background_active);
				} else {
					convertView.setBackgroundResource(R.drawable.menu_bg);
					ListView.LayoutParams rlParams = new ListView.LayoutParams(
							ListView.LayoutParams.MATCH_PARENT, 10);
					convertView.setLayoutParams(rlParams);
					convertView.setFocusable(false);
				}
			}
			if (menuText != null) {
				menuText.setText(menus[position]);
			}
			return convertView;
		}
	}

}
