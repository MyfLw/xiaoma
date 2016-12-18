package com.bwei.yunifang.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

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
 * Created by Mayuefeng on 2016/12/15.
 */

public class MianMOFragment extends Fragment {

    private static MianMOFragment fragment;

    private static final String TAG = "MianMOFragment";
    private List<ShuXingBean.DataBean> data;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 0:
                    ShuXingBean sxb= (ShuXingBean) msg.obj;
                    data = sxb.getData();
                    Log.d(TAG, "handleMessage: ++++"+data);
                    gridView.setAdapter(new ShuXingAdapter(getActivity(),data));
                    break;
                default :
                    break;
            }


        }
    };
    private String encode;
    private GridView gridView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.mianmo_fragment,null);
        gridView = (GridView) view.findViewById(R.id.gride);
        Bundle bundle = getArguments();
        if (bundle!=null){
        String id = bundle.getString("encode");
        encode = URLEncoder.encode(id);

        }
        Log.d(TAG, "onCreate: *****"+encode);
        initData();

        return view;
    }

    private void initData() {
        app.httpUtils.requestGet(Uri.INFO_ID + encode, ShuXingBean.class, new ANdebuk() {
            @Override
            public void onSuccess(BaseBean bean) {
                Message message = Message.obtain();
                message.what=0;
                message.obj=bean;
                handler.sendMessage(message);
            }

            @Override
            public void onSuccess_Fail() {

            }

            @Override
            public void onFail() {

            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }





}
