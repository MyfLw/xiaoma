package com.bwei.yunifang.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.adapter.GuideAdapter;

import java.util.ArrayList;

/**
 * Created by Mayuefeng on 2016/12/6.
 */

public class GuideActivity extends AppCompatActivity {

    private int[] pic = new int[]{
            R.drawable.guidance_1,
            R.drawable.guidance_2,
            R.drawable.guidance_3,
            R.drawable.guidance_4,
            R.drawable.guidance_5
    };
    private ArrayList<ImageView> imageViews;
    private static final String TAG = "GuideActivity";

    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        edit = sp.edit();
        boolean flag = sp.getBoolean("ok", false);
        if (flag == true) {
            startActivity(new Intent(GuideActivity.this, HomePageActivity.class));
            finish();
        }
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        imageViews = new ArrayList<>();
        for (int i = 0; i < pic.length; i++) {

            ImageView imageView = new ImageView(this);
            // 放入图片到imageView对象
            imageView.setImageResource(pic[i]);
            // 设置充满类型
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            // 把对象imageView放入集合views中
            imageViews.add(imageView);
            Log.d(TAG, "onCreate: " + imageViews);
        }
        viewPager.setAdapter(new GuideAdapter(this, imageViews));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 4) {
                    viewPager.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            switch (motionEvent.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    edit.putBoolean("ok", true);
                                    edit.commit();
                                    startActivity(new Intent(GuideActivity.this, HomePageActivity.class));
                                    finish();
                                    break;
                                default:
                                    break;
                            }
                            return true;
                        }
                    });
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
