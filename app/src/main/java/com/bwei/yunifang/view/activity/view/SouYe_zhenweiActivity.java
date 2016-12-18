package com.bwei.yunifang.view.activity.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Uitls.Uri;

/**
 *  * 作者：19084 on 2016/12/14 18:54
 *  * 邮箱：xjs250@163.com
 *  
 */
public class SouYe_zhenweiActivity extends AppCompatActivity {

    private WebView WEBvi;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.souye_zhenwei);

        //获得控件
        Init();
        WEBvi.getSettings().setJavaScriptEnabled(true);

//××××××××

       WEBvi.loadUrl(Uri.fangwei_chaxun);
        WEBvi.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;//super.shouldOverrideUrlLoading(view, url);
            }
        });

    }

    private void Init() {
        WEBvi = (WebView) findViewById(R.id.zhenwei_webview);

    }
}