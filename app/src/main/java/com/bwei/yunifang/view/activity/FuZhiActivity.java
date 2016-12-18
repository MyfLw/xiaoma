package com.bwei.yunifang.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Bean.ShuXingBean;
import com.bwei.yunifang.view.Not.ANdebuk;
import com.bwei.yunifang.view.Uitls.Uri;
import com.bwei.yunifang.view.activity.view.app;
import com.bwei.yunifang.view.adapter.ShuXingAdapter;

import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/16.
 */

public class FuZhiActivity extends AppCompatActivity {

    private GridView other_gride;
    private Handler handler = new Handler() {


        @Override
        public void handleMessage(Message msg) {

            ShuXingBean sxb = (ShuXingBean) msg.obj;
            data = sxb.getData();

            other_gride.setAdapter(new ShuXingAdapter(FuZhiActivity.this, data));


        }
    };
    private TextView title;
    private String encode;
    private List<ShuXingBean.DataBean> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuxing);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        encode = URLEncoder.encode(id);
        initView();
        initData();

    }

    private void initData() {
        app.httpUtils.requestGet(Uri.INFO_ID + encode, ShuXingBean.class, new ANdebuk() {
            @Override
            public void onSuccess(BaseBean bean) {
                Message message = Message.obtain();

                message.obj = bean;
                handler.sendMessage(message);
            }

            @Override
            public void onSuccess_Fail() {
                Log.e("ClassifyFragment", "ddfff");
            }

            @Override
            public void onFail() {
                Log.e("ClassifyFragment", "gfds");
            }
        });
        other_gride.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = data.get(i).getId();
                Intent intent = new Intent(FuZhiActivity.this, SouyeshangpinActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        title = (TextView) findViewById(R.id.other_title);
        other_gride = (GridView) findViewById(R.id.other_gride);
    }
}
