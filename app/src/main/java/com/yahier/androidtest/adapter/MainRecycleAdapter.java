package com.yahier.androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.metarial.MainItem;

/**
 * Created by yahier on 16/12/30.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView tvDes;
        public View lin;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.my_textview);
            tvDes = (TextView) v.findViewById(R.id.tvDes);
            lin = v.findViewById(R.id.lin);
            tvDes.setVisibility(View.VISIBLE);
        }
    }


    MainItem[] itemArray = null;

    public MainRecycleAdapter(MainItem[] itemArray) {
        this.itemArray = itemArray;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        MainItem item = itemArray[position];

        holder.mTextView.setText(item.getTitle());
        if (TextUtils.isEmpty(item.getDes())) {
            holder.tvDes.setVisibility(View.GONE);
        } else {
            holder.tvDes.setVisibility(View.VISIBLE);
            holder.tvDes.setText(item.getDes());
        }

        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onItemClck(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemArray.length;
    }


    public void setOnItemClick(OnItemClickListener listener) {
        this.listener = listener;
    }

    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClck(int i);
    }

}


