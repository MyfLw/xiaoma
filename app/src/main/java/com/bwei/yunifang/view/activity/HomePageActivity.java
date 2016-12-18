package com.bwei.yunifang.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.activity.view.ViewpagerNoDown;
import com.bwei.yunifang.view.adapter.HomeAdapter;
import com.bwei.yunifang.view.fragment.ClassifyFragment;
import com.bwei.yunifang.view.fragment.HomeFragment;
import com.bwei.yunifang.view.fragment.MineFragment;
import com.bwei.yunifang.view.fragment.ShopFragment;

import java.util.ArrayList;

/**
 * Created by Mayuefeng on 2016/12/6.
 */

public class HomePageActivity extends FragmentActivity implements View.OnClickListener {

    private RadioButton tv_home;
    private RadioButton tv_type;
    private RadioButton tv_shopping;
    private RadioButton tv_mine;
    private boolean flag = false;

    private ArrayList<Fragment> fragments;
 public static   ViewpagerNoDown viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initView();
        initFragment();
        viewPager.setCurrentItem(0);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction())
                {
                    case  MotionEvent.ACTION_SCROLL:
                        break;


                }
                return true;
            }
        });
        viewPager.setAdapter(new HomeAdapter(getSupportFragmentManager(), fragments));
        jiezhi();
    }
//接受返回值得
    private void jiezhi() {
       Intent intent = getIntent();
      int  i = intent.getIntExtra("int",3);
        if(i==4){
            viewPager.setCurrentItem(i);
            tv_mine.setChecked(true);

        }
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MineFragment());
    }

    private void initView() {
        tv_home = (RadioButton) findViewById(R.id.home);
        tv_type = (RadioButton) findViewById(R.id.type);
        tv_shopping = (RadioButton) findViewById(R.id.shopping);
        tv_mine = (RadioButton) findViewById(R.id.mine);
        viewPager = (ViewpagerNoDown) findViewById(R.id.homeViewPager);
        tv_home.setOnClickListener(this);
        tv_type.setOnClickListener(this);
        tv_shopping.setOnClickListener(this);
        tv_mine.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.type:
                viewPager.setCurrentItem(1);
                break;
            case R.id.shopping:
                viewPager.setCurrentItem(2);
                break;
            case R.id.mine:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

}
