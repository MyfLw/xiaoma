package com.bwei.yunifang.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.AllGoodsBean;
import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Not.ANdebuk;
import com.bwei.yunifang.view.Uitls.Uri;
import com.bwei.yunifang.view.activity.view.MyHomeGoodsGridview;
import com.bwei.yunifang.view.activity.view.app;
import com.bwei.yunifang.view.adapter.AllGoodsGridviewAdapter;

import java.util.ArrayList;


import java.util.Collections;
import java.util.List;

/**
 *  * 作者：19084 on 2016/12/15 19:28
 *  * 邮箱：xjs250@163.com
 *  
 */
public class Souyegenduo_Activaty extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_momre;
    private TextView tv_shengxu;
    private TextView tv_jiangxu;
    private TextView x_1;
    private TextView x_2;
    private TextView x_3;
    private MyHomeGoodsGridview gv_alldoods;

      private AllGoodsGridviewAdapter adapter;
   private List<AllGoodsBean.DataBean> data;
    private List<AllGoodsBean.DataBean> list1 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanbushanpin);
        initView();

        initData();
    }

    private void initData() {
  app.httpUtils.requestGet(Uri.suoyou_shangpin, AllGoodsBean.class, new ANdebuk() {
      @Override
      public void onSuccess(BaseBean bean) {
          //拿到数据
          AllGoodsBean allgoods = (AllGoodsBean) bean;
          data = allgoods.getData();
          //记录下默认的
          list1.addAll(data);
          //展示
          adapter = new AllGoodsGridviewAdapter(getApplication());
          gv_alldoods.setAdapter(adapter);
          adapter.addData(list1);
          gv_alldoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                   Tiao(getApplication(),SouyeshangpinActivity.class,data.get(i).getId());
              }
          });

      }

      @Override
      public void onSuccess_Fail() {

      }

      @Override
      public void onFail() {

      }
  });

    }
    public  void Tiao(Context context, Class cals ,String i)
    {
        Intent it=new Intent();
        it.setClass(context,cals);
        it.putExtra("id",i);
        startActivity(it);
        this.finish();
    }
    private void initView() {
        tv_momre = (TextView) findViewById(R.id.tv_moren);
        tv_shengxu = (TextView) findViewById(R.id.tv_shengxu);
        tv_jiangxu = (TextView) findViewById(R.id.tv_jiangxu);
        x_1 = (TextView) findViewById(R.id.x_moren);
        x_2 = (TextView) findViewById(R.id.x_shengxu);
        x_3 = (TextView) findViewById(R.id.x_jiaxu);
        tv_momre.setOnClickListener(this);
        tv_shengxu.setOnClickListener(this);
        tv_jiangxu.setOnClickListener(this);
        gv_alldoods = (MyHomeGoodsGridview) findViewById(R.id.gv_alldoods);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_moren:
                x_1.setVisibility(View.VISIBLE);
                x_2.setVisibility(View.INVISIBLE);
                x_3.setVisibility(View.INVISIBLE);
                adapter = new AllGoodsGridviewAdapter(this);
                gv_alldoods.setAdapter(adapter);
                adapter.addData(list1);
                break;
            case R.id.tv_shengxu:
                x_1.setVisibility(View.INVISIBLE);
                x_2.setVisibility(View.VISIBLE);
                x_3.setVisibility(View.INVISIBLE);
                //展示升序的适配器
                Collections.reverse(data);
                adapter = new AllGoodsGridviewAdapter(this);
                gv_alldoods.setAdapter(adapter);
                adapter.addData(data);
                break;
            case R.id.tv_jiangxu:
                x_1.setVisibility(View.INVISIBLE);
                x_2.setVisibility(View.INVISIBLE);
                x_3.setVisibility(View.VISIBLE);
                //展示降序的适配器
                Collections.sort(data);
                adapter = new AllGoodsGridviewAdapter(this);
                gv_alldoods.setAdapter(adapter);
                adapter.addData(data);
                break;

            default:
                break;
        }
    }
}
