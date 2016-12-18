package com.bwei.yunifang.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.fragment.GongXiaoFragment;

/**
 * Created by Mayuefeng on 2016/12/16.
 */

public class GongXiaoActivity extends FragmentActivity {

    private static final String TAG = "GongXiaoActivity";




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gongxiao);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        GongXiaoFragment gongXiaoFragment = new GongXiaoFragment();
        gongXiaoFragment.setArguments(bundle);
        transaction.replace(R.id.gongxiao_, gongXiaoFragment);
        transaction.commit();


    }



}
