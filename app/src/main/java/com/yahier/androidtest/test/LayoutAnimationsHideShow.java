/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yahier.androidtest.test;

// Need the following import to get access to the app resources, since this
// class is in a sub-package.


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.widget.LinearLayout;

import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.yahier.androidtest.R;

/**
 * This application demonstrates how to use LayoutTransition to automate
 * transition animations as items are hidden or shown in a container.
 */
@TargetApi(11)
@SuppressLint({ "NewApi", "NewApi", "NewApi" })
public class LayoutAnimationsHideShow extends Activity {

	private int numButtons = 1;
	ViewGroup container = null;
	private LayoutTransition mTransitioner;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_animations_hideshow);

		final CheckBox hideGoneCB = (CheckBox) findViewById(R.id.hideGoneCB);

		container = new LinearLayout(this);
		container.setLayoutParams(new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));

		// Add a slew of buttons to the container. We won't add any more buttons
		// at runtime, but
		// will just show/hide the buttons we've already created
		for (int i = 0; i < 4; ++i) {
			Button newButton = new Button(this);
			newButton.setText(String.valueOf(i));
			container.addView(newButton);
			newButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// v.setVisibility(hideGoneCB.isChecked() ? View.GONE :
					// View.INVISIBLE);
					v.setVisibility(View.GONE);
				}
			});
		}

		Button addButton = (Button) findViewById(R.id.addNewButton);
		addButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				for (int i = 0; i < container.getChildCount(); ++i) {
					View view = (View) container.getChildAt(i);
					view.setVisibility(View.VISIBLE);
				}
			}
		});

		
		ViewGroup parent = (ViewGroup) findViewById(R.id.parent);
		parent.addView(container);
		resetTransition();
	}

	/**
	 * 至关重要的动画
	 */
	private void resetTransition() {
		mTransitioner = new LayoutTransition();
		container.setLayoutTransition(mTransitioner);
	}

}