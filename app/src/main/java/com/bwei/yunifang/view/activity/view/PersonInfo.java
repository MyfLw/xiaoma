package com.bwei.yunifang.view.activity.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwei.yunifang.R;

/**
 * Created by Mayuefeng on 2016/12/9.
 */

public class PersonInfo extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.person_info);
        initView();
    }

    private void initView() {
        TextView user_head = (TextView) findViewById(R.id.user_head);
        TextView user_name = (TextView) findViewById(R.id.user_name);
        TextView user_sex = (TextView) findViewById(R.id.user_sex);
        TextView user_birthday = (TextView) findViewById(R.id.user_birthday);
        TextView user_addrs = (TextView) findViewById(R.id.user_addrs);
        user_head.setOnClickListener(this);
        user_name.setOnClickListener(this);
        user_sex.setOnClickListener(this);
        user_birthday.setOnClickListener(this);
        user_addrs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_head:
                View inflate = View.inflate(this, R.layout.user_head_popu, null);

                PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, 100, true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.showAtLocation(inflate, Gravity.CENTER,0,0);

                break;
            case R.id.user_name:
                break;
            case R.id.user_sex:
                break;
            case R.id.user_birthday:
                break;
            case R.id.user_addrs:
                break;

            default:
                break;
        }
    }
}
