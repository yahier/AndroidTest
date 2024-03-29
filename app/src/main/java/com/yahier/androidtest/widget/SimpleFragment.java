package com.yahier.androidtest.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhy on 16/6/6.
 */
public class SimpleFragment extends Fragment {
    public static SimpleFragment newInstance(String title) {
        Log.e("SimpleFragment", "title:" + title);
        SimpleFragment simpleFragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        simpleFragment.setArguments(bundle);
        return simpleFragment;
    }

    private String mTitle = "helloworld";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getActivity());
        tv.setTextSize(20);
        tv.setTextColor(Color.BLACK);
        tv.setText(mTitle);
        return tv;
    }
}
