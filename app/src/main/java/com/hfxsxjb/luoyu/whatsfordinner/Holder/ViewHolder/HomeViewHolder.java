package com.hfxsxjb.luoyu.whatsfordinner.Holder.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hfxsxjb.luoyu.whatsfordinner.R;

/**
 * Created by luoyu_000 on 2017/6/2.
 */

public class HomeViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public HomeViewHolder(View view) {
        super(view);
        textView = (TextView)view.findViewById(R.id.textView);
    }
}
