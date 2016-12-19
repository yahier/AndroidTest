package com.yahier.androidtest.widget;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

import com.yahier.androidtest.R;


public class TTextSwitcher extends Activity implements
		ViewFactory, OnClickListener {

	private Button buttonChangeText;
	private TextSwitcher myTextSwitcher;
	private DigitalClock myDigitalClock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.text_switch);

		this.buttonChangeText = (Button) super.findViewById(R.id.buttonChangeText);
		this.myTextSwitcher = (TextSwitcher) super.findViewById(R.id.myTextSwitcher);
		this.myDigitalClock = (DigitalClock) super.findViewById(R.id.myDigitalClock);
		this.buttonChangeText.setOnClickListener(this);
		this.myTextSwitcher.setFactory(this);


	}

	@Override
	public View makeView() {
		TextView textView = new TextView(this);
		textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
		textView.setTextSize(36);
		return textView;
	}

	@Override
	public void onClick(View v) {
		this.myDigitalClock.addTextChangedListener(textWatcher);
	}

	private android.text.TextWatcher textWatcher = new android.text.TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			TTextSwitcher.this.myTextSwitcher.setText(TTextSwitcher.this.myDigitalClock.getText());
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
			
		}
	};
}