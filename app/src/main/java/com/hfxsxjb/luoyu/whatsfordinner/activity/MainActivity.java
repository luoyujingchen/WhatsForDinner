package com.hfxsxjb.luoyu.whatsfordinner.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.hfxsxjb.luoyu.whatsfordinner.R;
import com.hfxsxjb.luoyu.whatsfordinner.adapter.HomeAdapter;

import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HomeAdapter.OnRecyclerViewItemClickedListener {
    RecyclerView recyclerView;
    HomeAdapter adapter;
    LinkedList<String> mDatas;
    TextInputEditText text;
    Button go;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.home_recyclerView);
        go = (Button) findViewById(R.id.go);
        text = (TextInputEditText) findViewById(R.id.text);
        mDatas = new LinkedList<String>();
        mDatas.push("1xc2cx301");
        adapter = new HomeAdapter(this, mDatas);
        adapter.setOnItemClickListener(this);
        gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        go.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.go:
                if (mDatas.size() == 0)
                    Snackbar.make(v, "当前候选项为空，至少给个选择吧~", LENGTH_SHORT).show();
                else if (mDatas.size() == 1 && mDatas.pop().equals("1xc2cx301")) {
                    Snackbar.make(v, "当前候选项为空，至少给个选择吧~", LENGTH_SHORT).show();
                } else {
                    int i, n = mDatas.size();
                    Random s = new Random();
                    i = abs((int) s.nextLong()) % (n - 1);
                    Snackbar.make(v, "当前选择的是~~~：" + mDatas.get(i), LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onItemClicked(View view, int position) {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialog_exittext, null);
        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.add_new_text);
        new AlertDialog.Builder(this).setView(promptsView).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (userInput.getText() != null && !userInput.getText().equals("")) {
                    mDatas.push(userInput.getText().toString());
                    refresh();
                }
            }
        }).setNegativeButton("取消", null).show();
/*        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager)MainActivity.this.getSystemService(INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }

        }, 100);  //在0.1秒后打开*/

    }

    @Override
    public void onItemLongClicked(View view, int position) {
        adapter.removeItem(position);
        mDatas.remove(position);
    }

    public void refresh() {
        adapter.onDatasChanged(mDatas);
        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
    }
}
