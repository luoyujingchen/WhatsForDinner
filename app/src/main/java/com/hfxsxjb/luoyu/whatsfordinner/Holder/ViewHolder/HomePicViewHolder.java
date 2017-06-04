package com.hfxsxjb.luoyu.whatsfordinner.Holder.ViewHolder;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfxsxjb.luoyu.whatsfordinner.R;

/**
 * Created by luoyu_000 on 2017/6/2.
 */

public class HomePicViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;

    public HomePicViewHolder(View view) {
        super(view);
        imageView = (ImageView) view.findViewById(R.id.add_new);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
