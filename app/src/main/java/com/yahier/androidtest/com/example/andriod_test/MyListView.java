package com.yahier.androidtest.com.example.andriod_test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yahier.androidtest.R;

/**
 * @author yahier
 * 
 */
public class MyListView extends Activity {

	boolean load = false;
	final int size = 20;
	List datas = new ArrayList();
	ArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		ListView list = (ListView) findViewById(R.id.list);
		TextView text = (TextView) findViewById(R.id.text);
		list.setEmptyView(text);

		for (int i = 0; i < size; i++) {
			datas.add(i + "");

		}
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
				datas);
		list.setAdapter(adapter);

		list.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem + visibleItemCount == datas.size()) {

					System.out.println(2);
					if (load)
						return;

					if (!load)
						load();

				}

			}
		});

	}

	void load() {

		for (int i = 0; i < size; i++) {
			datas.add((datas.size() + 1) + "");
		}
		adapter.notifyDataSetChanged();
		load = false;
	}

}
