package com.klisly.iguilty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.klisly.iguilty.ui.MenuContainerActivity;



public class BootstrapActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 Intent intent = new Intent(BootstrapActivity.this,MenuContainerActivity.class);
		 startActivity(intent);
	}

	
}
