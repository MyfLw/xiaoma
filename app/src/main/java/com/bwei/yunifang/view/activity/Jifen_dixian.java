package com.bwei.yunifang.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Uitls.Uri;

/**
 *  * 作者：19084 on 2016/12/14 19:07
 *  * 邮箱：xjs250@163.com
 *  
 */
public class Jifen_dixian extends AppCompatActivity {
    private  WebView webView;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.souye_jifendixian);

        //获得控件
        Init();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(Uri.huiyuan_libao);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;//super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private void Init() {
       webView= (WebView) findViewById(R.id.jifendixian_webview);

    }
}
