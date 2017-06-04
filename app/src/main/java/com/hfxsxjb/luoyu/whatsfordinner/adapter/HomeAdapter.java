package com.hfxsxjb.luoyu.whatsfordinner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfxsxjb.luoyu.whatsfordinner.Holder.ViewHolder.HomeViewHolder;
import com.hfxsxjb.luoyu.whatsfordinner.R;
import com.hfxsxjb.luoyu.whatsfordinner.activity.MainActivity;

import java.util.LinkedList;

/**
 * Created by luoyu_000 on 2017/6/2.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    Context context;
    LinkedList<String> datas;
    public HomeAdapter(Context context,LinkedList<String> datas) {
        super();
        this.context = context;
        this.datas = datas;
    }


    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_layout,parent,false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(view);
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
       holder.textView.setText(datas.get(position));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void onDatasChanged(LinkedList<String> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }

    //备用监听接口
    public static interface OnRecyclerViewItemClickedListener{
        void onItemClicked(View view);
        void onItemLongClicked(View view);
    }
    private OnRecyclerViewItemClickedListener mOnItemClickedListener = null;
    public void setOnItemClickListener(OnRecyclerViewItemClickedListener listener) {
        mOnItemClickedListener = listener;
    }
}
