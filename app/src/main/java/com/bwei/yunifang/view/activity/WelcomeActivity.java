package com.bwei.yunifang.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.yunifang.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Mayuefeng on 2016/12/6.
 */

public class WelcomeActivity extends AppCompatActivity {

    private TextView textView;
    private int count = 4;
    private ImageView imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //取消状态栏

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activivty_welcome);
        textView = (TextView) findViewById(R.id.count_down);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText((count -= 1) + "");
                        if (count == 0) {
                            startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
                            finish();
                            timer.cancel();
                        }

                    }
                });
            }
        }, 0, 1000);

    }




    public void jump(View view) {
        startActivity(new Intent(this, HomePageActivity.class));
        finish();

    }

}
