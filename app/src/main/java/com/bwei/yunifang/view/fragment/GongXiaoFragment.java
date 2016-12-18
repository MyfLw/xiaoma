package com.bwei.yunifang.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Bean.ShuXingBean;
import com.bwei.yunifang.view.Not.ANdebuk;
import com.bwei.yunifang.view.Uitls.Uri;
import com.bwei.yunifang.view.activity.FuZhiActivity;
import com.bwei.yunifang.view.activity.SouyeshangpinActivity;
import com.bwei.yunifang.view.activity.view.app;
import com.bwei.yunifang.view.adapter.ShuXingAdapter;

import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/16.
 */

public class GongXiaoFragment extends Fragment {

    private static GongXiaoFragment fragment;
    private String encode;
    private List<ShuXingBean.DataBean> data;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            ShuXingBean sxb = (ShuXingBean) msg.obj;
            data = sxb.getData();
            // Log.d(TAG, "handleMessage: ++++"+data);
            gridView.setAdapter(new ShuXingAdapter(getActivity(), data));


        }
    };
    private GridView gridView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_gongxiao, null);
        gridView = (GridView) view.findViewById(R.id.gongxiao_gride);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String id = bundle.getString("id");
            encode = URLEncoder.encode(id);

        }
        initData();

        return view;
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

            }

            @Override
            public void onFail() {

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = data.get(i).getId();
                Intent intent = new Intent(getActivity(), SouyeshangpinActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}

