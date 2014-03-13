package com.klisly.iguilty.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.klisly.iguilty.R;
import com.klisly.iguilty.bean.MenuEntry;
import com.klisly.iguilty.bean.MenuEntry.State;
import com.klisly.iguilty.ui.MenuContainerActivity;

public class MenuListAdapter extends BaseAdapter {
	private MenuContainerActivity context;// 运行上下文
	private List<MenuEntry> listItems;// 数据集合
	private LayoutInflater listContainer;// 视图容器
	private int itemViewResource;// 自定义项视图源

	public class ListItemView {
		public TextView mTvTitle;
	}

	public MenuListAdapter(MenuContainerActivity context, List<MenuEntry> data,
			int resource) {
		this.context = context;
		this.listContainer = LayoutInflater.from(context); // 创建视图容器并设置上下文
		this.itemViewResource = resource;
		this.listItems = data;
	}

	public int getCount() {
		return listItems.size();
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// 自定义视图
		ListItemView listItemView = null;
		if (convertView == null) {
			// 获取list_item布局文件的视图
			convertView = listContainer.inflate(this.itemViewResource, null);
			listItemView = new ListItemView();
			// 获取控件对象
			listItemView.mTvTitle = (TextView) convertView
					.findViewById(R.id.tv_menu_text);
			convertView.setTag(listItemView);
		} else {
			listItemView = (ListItemView) convertView.getTag();
		}

		convertView.setBackgroundResource(R.drawable.menu_item);
		final MenuEntry menuEntry = listItems.get(position);

		if (menuEntry.getName().equalsIgnoreCase("seperate")) {
			convertView.setLayoutParams(new ListView.LayoutParams(
					ListView.LayoutParams.MATCH_PARENT, 10));
			convertView.setFocusable(false);
		} else {
			listItemView.mTvTitle.setText(menuEntry.getName());
			if (menuEntry.getState() == State.CHECKED) {
				convertView
						.setBackgroundResource(R.drawable.side_menu_background_active);
			} else {
				convertView.setBackgroundResource(R.drawable.menu_item);
			}

			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					
					for (int i = 0; i < listItems.size(); i++) {
						listItems.get(i).setState(State.UNCHECKED);
					}
					menuEntry.setState(State.CHECKED);
					
					context.switchFragment(menuEntry.getFragment());
					notifyDataChange();
				}
			});
		}

		return convertView;
	}

	public void notifyDataChange() {
		this.notifyDataSetChanged();
	}
}