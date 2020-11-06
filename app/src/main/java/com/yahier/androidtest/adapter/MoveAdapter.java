package com.yahier.androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.util.move_hepler.ItemTouchHelperAdapter;
import com.yahier.androidtest.vo.CommonItem;

import java.util.Collections;
import java.util.List;


public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MyViewHolder> implements ItemTouchHelperAdapter {
    private List<CommonItem> listData;

    public MoveAdapter(List<CommonItem> listData) {
        this.listData = listData;
        initDivider();
    }

    public void setListData(List<CommonItem> listData){
        this.listData = listData;
        notifyDataSetChanged();
    }

    public void addListData(List<CommonItem> listData){
        this.listData.addAll(listData);
        notifyDataSetChanged();
    }


    public List<CommonItem> getDataList() {
        return listData;
    }

    private void initDivider() {
        if (listData.size() == 0) {
            listData.add(CommonItem.getMark("口袋1"));
        } else {
            listData.add(0, CommonItem.getMark("口袋1"));
            listData.add(CommonItem.getMark("口袋2"));
        }
    }

    @Override
    public int getItemViewType(int position) {
        CommonItem item = listData.get(position);
        return item.type;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        switch (viewType) {
            case CommonItem.typeDivider:
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_divider, parent, false);
                break;
            default:
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_common, parent, false);
                break;
        }
        MyViewHolder holder = new MyViewHolder(rootView);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(listData.get(position).name);
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(listData, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
        }
    }


}

