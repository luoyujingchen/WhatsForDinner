package com.hfxsxjb.luoyu.whatsfordinner.activity;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.hfxsxjb.luoyu.whatsfordinner.R;
import com.hfxsxjb.luoyu.whatsfordinner.adapter.HomeAdapter;

import java.util.LinkedList;
import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    HomeAdapter adapter;
    LinkedList<String> mDatas;
    TextInputEditText text;
    Button go, addItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.home_recyclerView);
        go = (Button) findViewById(R.id.go);
        addItem = (Button) findViewById(R.id.add_item);
        text = (TextInputEditText) findViewById(R.id.text);
        mDatas = new LinkedList<String>();
        adapter = new HomeAdapter(this, mDatas);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adapter);
        go.setOnClickListener(this);
        addItem.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.go:
                if (mDatas.size() == 0)
                    Snackbar.make(v,"当前候选项为空，至少给个选择吧~",LENGTH_SHORT).show();
                else {
                    int i,n = mDatas.size();
                    Random s = new Random();
                    i = abs((int)s.nextLong())%n;
                    Snackbar.make(v,"当前选择的是~~~："+mDatas.get(i),LENGTH_SHORT).show();

                }
                break;
            case R.id.add_item:
                if (text.getText() != null && !text.getText().equals("")) {
                    mDatas.add(mDatas.size(), text.getText().toString());
                    adapter.onDatasChanged(mDatas);
                    text.setText("");
                    text.clearFocus();
                }
                break;
            default:
                break;
        }
    }
}
