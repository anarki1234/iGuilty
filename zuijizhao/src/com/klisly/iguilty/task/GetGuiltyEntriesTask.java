package com.klisly.iguilty.task;

import java.util.HashMap;

import com.klisly.iguilty.IGuiltyApplication.AppBaseTask;

public class GetGuiltyEntriesTask extends AppBaseTask {
	private HashMap<String,String> mParameters;
	private String mLastEntryTimeStamp = "";
	
	public GetGuiltyEntriesTask(String mLastEntryTimeStamp) {
		super();
		this.mLastEntryTimeStamp = mLastEntryTimeStamp;
	}
	@Override
	protected String doInBackground(String... params) {
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
}
