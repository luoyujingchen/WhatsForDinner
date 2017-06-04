package com.hfxsxjb.luoyu.whatsfordinner.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hfxsxjb.luoyu.whatsfordinner.Holder.ViewHolder.HomePicViewHolder;
import com.hfxsxjb.luoyu.whatsfordinner.Holder.ViewHolder.HomeTextViewHolder;
import com.hfxsxjb.luoyu.whatsfordinner.R;

import java.util.LinkedList;

/**
 * Created by luoyu_000 on 2017/6/2.
 */

public class HomeAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    LinkedList<String> datas;

    public HomeAdapter(Context context, LinkedList<String> datas) {
        super();
        this.context = context;
        this.datas = datas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_text_item_layout, parent, false);
            viewHolder = new HomeTextViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.recycler_pic_item_layout, parent, false);
            viewHolder = new HomePicViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
//        if (datas.get(position).equals("1xc2cx301"))
        if ((position+1) == datas.size())
            return 0;
        return 1;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        int i = position;

        if (holder instanceof HomeTextViewHolder) {
            ((HomeTextViewHolder) holder).textView.setText(datas.get(position));
            ((HomeTextViewHolder) holder).textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickedListener.onItemLongClicked(v,holder.getLayoutPosition());
                    return false;
                }
            });
        } else {
            ((HomePicViewHolder) holder).imageView.setImageResource(R.drawable.add_new);
            ((HomePicViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickedListener.onItemClicked(v,holder.getLayoutPosition());
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (datas == null || datas.size() ==0)
            return 1;
        return datas.size();
    }

    public void onDatasChanged(LinkedList<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        datas.remove(position);
        notifyDataSetChanged();
    }


    //备用监听接口
    public static interface OnRecyclerViewItemClickedListener extends View.OnClickListener {
        void onItemClicked(View view,int position);

        void onItemLongClicked(View view,int position);
    }

    private OnRecyclerViewItemClickedListener mOnItemClickedListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickedListener listener) {
        mOnItemClickedListener = listener;
    }
}
