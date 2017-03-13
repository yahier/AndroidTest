package com.yahier.androidtest.adapter;

import android.view.View;
import android.widget.BaseAdapter;

public abstract class CommonAdapter extends BaseAdapter {

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}



	protected View findId(View view, int id) {
		return view.findViewById(id);
	}



}
