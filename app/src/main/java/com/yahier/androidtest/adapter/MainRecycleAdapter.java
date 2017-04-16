package com.yahier.androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yahier.androidtest.R;

import java.util.List;

/**
 * Created by yahier on 16/12/30.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.ViewHolder> {
    private List<String> titles;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
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


    public MainRecycleAdapter(List<String> titles) {
        this.titles = titles;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(titles.get(position));
        holder.tvDes.setText(titles.get(position));

        holder.lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClck(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }


    public void setOnItemClick(OnItemClickListener listener) {
        this.listener = listener;
    }

    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClck(int i);
    }

}


