package com.klisly.iguilty.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.klisly.iguilty.R;
import com.klisly.iguilty.bean.GuiltyEntry;
//Guilty 实体类
public class ListViewHotAdapter extends BaseAdapter{
	private Context 					context;//运行上下文
	private List<GuiltyEntry> 				listItems;//数据集合
	private LayoutInflater 				listContainer;//视图容器
	private int 						itemViewResource;//自定义项视图源 
	static class ListItemView{				//自定义控件集合  
        public TextView mTvBtnAvatar;
        public TextView mTvNickName;
        public TextView mTvContentText;
        public TextView mTvBtnContentAduio;
        public ImageView mTvBtnContentImg;
        public LinearLayout mLlBtnPraise;
        public TextView mTvPraiseCount;
        public LinearLayout mLlBtnShare;
        public LinearLayout mLlBtnComment;
        
	}  

	/**
	 * 实例化Adapter
	 * @param context
	 * @param data
	 * @param resource
	 */
	public ListViewHotAdapter(Context context, List<GuiltyEntry> data,int resource) {
		this.context = context;			
		this.listContainer = LayoutInflater.from(context);	//创建视图容器并设置上下文
		this.itemViewResource = resource;
		this.listItems = data;
	}
	
	public int getCount() {
		return listItems.size();
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}
	
	/**
	 * ListView Item设置
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//自定义视图
		ListItemView  listItemView = null;
		if (convertView == null) {
			//获取list_item布局文件的视图
			convertView = listContainer.inflate(this.itemViewResource, null);
			listItemView = new ListItemView();
			//获取控件对象
			listItemView.mTvBtnAvatar = (TextView)convertView.findViewById(R.id.tv_btn_user_avatar);
			listItemView.mTvNickName = (TextView)convertView.findViewById(R.id.tv_user_name);
			listItemView.mTvContentText = (TextView)convertView.findViewById(R.id.tv_content);
			listItemView.mTvBtnContentAduio = (TextView)convertView.findViewById(R.id.tv_btn_content_aduio);
			listItemView.mTvBtnContentImg = (ImageView)convertView.findViewById(R.id.iv_content_picture);
			listItemView.mLlBtnPraise = (LinearLayout)convertView.findViewById(R.id.ll_btn_praise);
			listItemView.mTvPraiseCount = (TextView)convertView.findViewById(R.id.tv_praise_count);
			listItemView.mLlBtnShare = (LinearLayout)convertView.findViewById(R.id.ll_btn_share);
			listItemView.mLlBtnComment = (LinearLayout)convertView.findViewById(R.id.ll_btn_comment);
			//设置控件集到convertView
			convertView.setTag(listItemView);
		}else {
			listItemView = (ListItemView)convertView.getTag();
		}	
		
		//设置文字和图片
		GuiltyEntry guilty = listItems.get(position);
		
		listItemView.mTvBtnAvatar.setTag(guilty);
		listItemView.mTvBtnAvatar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		listItemView.mTvNickName.setText(guilty.getNickname());
		Log.i("ListViewAdapter",guilty.getNickname());
		listItemView.mTvContentText.setText(guilty.getContenText());

		listItemView.mTvBtnContentAduio.setTag(guilty);
		listItemView.mTvBtnContentAduio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
//		listItemView.mTvBtnContentImg.  Load Image
		listItemView.mTvBtnContentImg.setTag(guilty);
		listItemView.mTvBtnContentImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		listItemView.mLlBtnPraise.setTag(guilty);
		listItemView.mLlBtnPraise.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		listItemView.mTvPraiseCount.setText(guilty.getPraise()+"");
		
		listItemView.mLlBtnShare.setTag(guilty);
		listItemView.mLlBtnShare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		listItemView.mLlBtnComment.setTag(guilty);
		listItemView.mLlBtnComment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return convertView;
	}
}