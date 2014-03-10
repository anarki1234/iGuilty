package com.klisly.iguilty;

import com.klisly.iguilty.ui.MenuContainerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class BootstrapActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 Intent intent = new Intent(BootstrapActivity.this,MenuContainerActivity.class);
		 startActivity(intent);
	}

	
}
