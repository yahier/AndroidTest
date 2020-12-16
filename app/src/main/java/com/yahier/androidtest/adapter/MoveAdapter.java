package com.yahier.androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.util.move_hepler.ItemTouchHelperAdapter;
import com.yahier.androidtest.util.move_hepler.ItemTouchHelperViewHolder;
import com.yahier.androidtest.util.move_hepler.OnStartDragListener;
import com.yahier.androidtest.vo.CommonItem;

import java.util.Collections;
import java.util.List;


public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MyViewHolder> implements ItemTouchHelperAdapter {
    private List<CommonItem> listData;

    public MoveAdapter(List<CommonItem> listData) {
        this.listData = listData;
        initDivider();
    }

    public void setListData(List<CommonItem> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    public void addListData(List<CommonItem> listData) {
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

    /**
     * 当前测试发现一个特性，viewType相同的item才能交换。
     */
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
        CommonItem commonItem = listData.get(position);
        holder.tvName.setText(commonItem.name);
        holder.tvSize.setText(String.valueOf(commonItem.size));


        holder.itemView.setOnLongClickListener(v -> {
            if (commonItem.type == CommonItem.typeNormal && onStartDragListener != null)
                onStartDragListener.onStartDrag(holder);

            return true;
        });

    }

    /**
     * 查看物品的口袋名称
     */
    public String getPocketName(int position) {
        for (int i = position; i >= 0; i--) {
            CommonItem commonItem = listData.get(i);
            if (commonItem.type == CommonItem.typeDivider) {
                return commonItem.name;
            }
        }

        return "";
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Log.e("口袋测试", "fromPosition" + fromPosition + "  toPosition:" + toPosition);
        Collections.swap(listData, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }


    @Override
    public void onItemDismiss(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }


    OnStartDragListener onStartDragListener;

    public void setOnStartDragListener(OnStartDragListener onStartDragListener) {
        this.onStartDragListener = onStartDragListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
        public TextView tvName, tvSize;

        MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvSize = view.findViewById(R.id.tvSize);
        }

        @Override
        public void onItemSelected(int position) {
            CommonItem sourceItem = listData.get(position);
            if (sourceItem.size > 1) {
                //以下是复制品
                int leftSize = sourceItem.size - 1;
                CommonItem commonItem1 = CommonItem.getNormal(sourceItem.name, leftSize);
                listData.add(position, commonItem1);

                sourceItem.size = 1;
                notifyItemInserted(position);

            }

        }

        @Override
        public void onItemClear() {

        }
    }


}

