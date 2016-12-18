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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Bean.ClassifyBean;
import com.bwei.yunifang.view.Not.ANdebuk;
import com.bwei.yunifang.view.Uitls.Uri;
import com.bwei.yunifang.view.activity.FuZhiActivity;
import com.bwei.yunifang.view.activity.GongXiaoActivity;
import com.bwei.yunifang.view.activity.ShuXingActivity;
import com.bwei.yunifang.view.activity.SouyeshangpinActivity;
import com.bwei.yunifang.view.activity.view.app;
import com.bwei.yunifang.view.adapter.StarAdapter;

import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/6.
 */

public class ClassifyFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView mianmo, runfushui, runfuru, jiemianru, other, taozhuan, bushui, shuhuan, konyou, meibai, jinzhi;
    private GridView star;

    private Button gride_wenhe, gride_zhongx, gride_ganxing, gride_youxing, gride_doudou, gride_mingan;
    private List<ClassifyBean.DataBean.GoodsBriefBean> goodsBrief;
    ClassifyBean list;
    private Handler handler = new Handler() {


        @Override
        public void handleMessage(Message msg) {
            BaseBean li = (BaseBean) msg.obj;
            list = (ClassifyBean) li;
            goodsBrief = list.getData().getGoodsBrief();
            star.setAdapter(new StarAdapter(getActivity(), goodsBrief));
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_classify,null);
        initView();


        return view;
    }

    private void initView() {
        mianmo = (ImageView) view.findViewById(R.id.mianmo);
        runfushui = (ImageView) view.findViewById(R.id.runfushui);
        runfuru = (ImageView) view.findViewById(R.id.runfuru);
        jiemianru = (ImageView) view.findViewById(R.id.jiemianru);
        other = (ImageView) view.findViewById(R.id.other);
        taozhuan = (ImageView) view.findViewById(R.id.taozhuan);
        bushui = (ImageView) view.findViewById(R.id.bushui);
        shuhuan = (ImageView) view.findViewById(R.id.shuhuan);
        konyou = (ImageView) view.findViewById(R.id.konyou);
        meibai = (ImageView) view.findViewById(R.id.meibai);
        jinzhi = (ImageView) view.findViewById(R.id.jinzhi);
        gride_wenhe = (Button) view.findViewById(R.id.gride_wenhe);
        gride_zhongx = (Button) view.findViewById(R.id.gride_zhongx);
        gride_ganxing = (Button) view.findViewById(R.id.gride_ganxing);
        gride_youxing = (Button) view.findViewById(R.id.gride_youxing);
        gride_doudou = (Button) view.findViewById(R.id.gride_doudou);
        gride_mingan = (Button) view.findViewById(R.id.gride_mingan);
        star = (GridView) view.findViewById(R.id.star);
        mianmo.setOnClickListener(this);
        runfushui.setOnClickListener(this);
        runfuru.setOnClickListener(this);
        jiemianru.setOnClickListener(this);
        other.setOnClickListener(this);
        taozhuan.setOnClickListener(this);
        bushui.setOnClickListener(this);
        shuhuan.setOnClickListener(this);
        konyou.setOnClickListener(this);
        meibai.setOnClickListener(this);
        jinzhi.setOnClickListener(this);
        gride_wenhe.setOnClickListener(this);
        gride_zhongx.setOnClickListener(this);
        gride_ganxing.setOnClickListener(this);
        gride_youxing.setOnClickListener(this);
        gride_doudou.setOnClickListener(this);
        gride_mingan.setOnClickListener(this);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Innt();
        star.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Context context = getActivity().getApplicationContext();

                Intent intent = new Intent(getActivity(), SouyeshangpinActivity.class);
                intent.putExtra("id", goodsBrief.get(i).getId());
                startActivity(intent);

            }
        });

    }

    private void Innt() {

        app.httpUtils.requestGet(Uri.FenLei, ClassifyBean.class, new ANdebuk() {
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mianmo:
                Intent intent = new Intent(getActivity(), ShuXingActivity.class);
                intent.putExtra("id", list.getData().getCategory().get(1).getChildren().get(6).getId());
                startActivity(intent);
                break;
            case R.id.runfushui:
                Intent intent1 = new Intent(getActivity(), ShuXingActivity.class);
                intent1.putExtra("id", list.getData().getCategory().get(1).getChildren().get(1).getId());
                startActivity(intent1);

                break;
            case R.id.runfuru:
                Intent intent2 = new Intent(getActivity(), ShuXingActivity.class);
                intent2.putExtra("id", list.getData().getCategory().get(1).getChildren().get(2).getId());
                startActivity(intent2);

                break;
            case R.id.jiemianru:
                Intent intent3 = new Intent(getActivity(), ShuXingActivity.class);
                intent3.putExtra("id", list.getData().getCategory().get(1).getChildren().get(3).getId());
                startActivity(intent3);
                break;
            case R.id.other:
                Intent intent4 = new Intent(getActivity(), ShuXingActivity.class);
                intent4.putExtra("id", list.getData().getCategory().get(1).getChildren().get(4).getId());
                startActivity(intent4);
                break;
            case R.id.taozhuan:
                Intent intent5 = new Intent(getActivity(), ShuXingActivity.class);
                intent5.putExtra("id", list.getData().getCategory().get(1).getChildren().get(5).getId());
                startActivity(intent5);
                break;
            case R.id.bushui:
                Intent intent6 = new Intent(getActivity(), GongXiaoActivity.class);
                intent6.putExtra("id", list.getData().getCategory().get(0).getChildren().get(0).getId());
                startActivity(intent6);
                break;
            case R.id.shuhuan:
                Intent intent7 = new Intent(getActivity(), GongXiaoActivity.class);
                intent7.putExtra("id", list.getData().getCategory().get(0).getChildren().get(1).getId());
                startActivity(intent7);
                break;
            case R.id.konyou:
                Intent intent8 = new Intent(getActivity(), GongXiaoActivity.class);
                intent8.putExtra("id", list.getData().getCategory().get(0).getChildren().get(2).getId());
                startActivity(intent8);
                break;
            case R.id.meibai:
                Intent intent9 = new Intent(getActivity(), GongXiaoActivity.class);
                intent9.putExtra("id", list.getData().getCategory().get(0).getChildren().get(3).getId());
                startActivity(intent9);
                break;
            case R.id.jinzhi:
                Intent intent10 = new Intent(getActivity(), GongXiaoActivity.class);
                intent10.putExtra("id", list.getData().getCategory().get(0).getChildren().get(4).getId());
                startActivity(intent10);
                break;
            case R.id.gride_wenhe:
                Intent intent11 = new Intent(getActivity(), FuZhiActivity.class);
                intent11.putExtra("id", list.getData().getCategory().get(2).getChildren().get(4).getId());
                startActivity(intent11);
                break;
            case R.id.gride_doudou:
                Intent intent12 = new Intent(getActivity(), FuZhiActivity.class);
                intent12.putExtra("id", list.getData().getCategory().get(2).getChildren().get(1).getId());
                startActivity(intent12);
                break;
            case R.id.gride_ganxing:
                Intent intent13 = new Intent(getActivity(), FuZhiActivity.class);
                intent13.putExtra("id", list.getData().getCategory().get(2).getChildren().get(2).getId());
                startActivity(intent13);
                break;
            case R.id.gride_mingan:
                Intent intent14 = new Intent(getActivity(), FuZhiActivity.class);
                intent14.putExtra("id", list.getData().getCategory().get(2).getChildren().get(3).getId());
                startActivity(intent14);
                break;
            case R.id.gride_youxing:
                Intent intent15 = new Intent(getActivity(), FuZhiActivity.class);
                intent15.putExtra("id", list.getData().getCategory().get(2).getChildren().get(4).getId());
                startActivity(intent15);
                break;
            case R.id.gride_zhongx:
                Intent intent16 = new Intent(getActivity(), FuZhiActivity.class);
                intent16.putExtra("id", list.getData().getCategory().get(2).getChildren().get(5).getId());
                startActivity(intent16);
                break;
            default:
                break;
        }
    }
}
