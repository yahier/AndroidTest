package com.yahier.androidtest.ui.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yahier.androidtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahier on 16/12/30.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.my_textview);
        }
    }


    private List<People> list;

    public MainRecycleAdapter() {
        list = new ArrayList<>();
    }

    public void setData(List<People> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void refreshSingleItem(int position, String name) {
        list.get(position).setName(name);
        notifyItemChanged(position);
    }

    @Override
    public MainRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tv, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        People item = list.get(position);
        holder.mTextView.setText(item.getName());

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClck(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setOnItemClick(OnItemClickListener listener) {
        this.listener = listener;
    }

    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClck(int i);
    }

}


