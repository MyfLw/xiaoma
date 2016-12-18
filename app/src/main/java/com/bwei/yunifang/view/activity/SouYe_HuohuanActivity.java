package com.bwei.yunifang.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Uitls.Uri;

/**
 *  * 作者：19084 on 2016/12/14 18:54
 *  * 邮箱：xjs250@163.com
 *  
 */
public class SouYe_HuohuanActivity extends AppCompatActivity {

    private WebView WEBvi;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.souye_huohuanzuanqu);

        //获得控件
        Init();
        WEBvi.getSettings().setJavaScriptEnabled(true);

//××××××××

       WEBvi.loadUrl(Uri.jifen_zhuanqu);


    }

    private void Init() {
        WEBvi = (WebView) findViewById(R.id.huohuan_webview);

    }
}