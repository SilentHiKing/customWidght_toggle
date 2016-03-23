package com.hurenbing.togglebutton;

import com.hurenbing.togglebutton.view.MyToggleButton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyToggleButton my_toggle_button = (MyToggleButton) findViewById(R.id.my_toggle_button);
		my_toggle_button.setSlideBackground(R.drawable.slide_background, R.drawable.slide_icon);
		my_toggle_button.setState(true);
		
	}

	

}
