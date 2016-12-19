package com.yahier.androidtest.ver.tab;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;

import com.yahier.androidtest.R;


/**
 * 爱心的入�?包含救助 爱心�?求助三个部分
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("deprecation")
public class LoveMain extends TabActivity implements OnClickListener {
	final String tab1 = "HELP";
	final String tab2 = "LOVE";
	final String tab3 = "ASK";
	TabHost tabHost;
	RadioButton helpBtn, heartBtn, askBtn;

	/**
	 * ��Ҫ��ɫ�� �����tabչʾ
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.love_main);


		tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec(tab1).setIndicator(tab1)
				.setContent(new Intent(this, LoveHelp.class)));

		tabHost.addTab(tabHost.newTabSpec(tab2).setIndicator(tab2)
				.setContent(new Intent(this, LoveHeart.class)));

		tabHost.addTab(tabHost.newTabSpec(tab3).setIndicator(tab3)
				.setContent(new Intent(this, LoveAsk.class)));

		helpBtn = (RadioButton) findViewById(R.id.love_help_tab);
		heartBtn = (RadioButton) findViewById(R.id.love_heart_tab);
		askBtn = (RadioButton) findViewById(R.id.love_ask_tab);

		helpBtn.setOnClickListener(this);

		heartBtn.setOnClickListener(this);
		askBtn.setOnClickListener(this);
		heartBtn.setChecked(true);
		tabHost.setCurrentTabByTag(tab2);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.love_help_tab:
			tabHost.setCurrentTabByTag(tab1);
			helpBtn.setChecked(true);
			heartBtn.setChecked(false);
			askBtn.setChecked(false);
			break;
		case R.id.love_heart_tab:
			tabHost.setCurrentTabByTag(tab2);
			helpBtn.setChecked(false);
			heartBtn.setChecked(true);
			askBtn.setChecked(false);
			break;
		case R.id.love_ask_tab:
			tabHost.setCurrentTabByTag(tab3);
			helpBtn.setChecked(false);
			heartBtn.setChecked(false);
			askBtn.setChecked(true);
			break;
		}
	}

}
