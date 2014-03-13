package com.klisly.iguilty.bean;

import com.klisly.iguilty.fragment.BaseFragment;

public class MenuEntry {
	private String name;
	private BaseFragment fragment;
	private State  state;
	public static enum State{CHECKED,UNCHECKED};
	public MenuEntry(String name ,State state ,BaseFragment fragment) {
		super();
		this.name = name;
		this.state = state;
		this.fragment = fragment;
	}

	public MenuEntry() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseFragment getFragment() {
		return fragment;
	}

	public void setFragment(BaseFragment fragment) {
		this.fragment = fragment;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
