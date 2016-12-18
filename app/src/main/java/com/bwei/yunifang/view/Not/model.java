package com.bwei.yunifang.view.Not;

import android.util.Log;

import com.bwei.yunifang.view.Uitls.Uri;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.security.PublicKey;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *  * 作者：19084 on 2016/12/10 10:18
 *  * 邮箱：xjs250@163.com
 *  
 */
public class model {
  private  OKjiekouchuan ks;
    private final Gson gson;
    public model() {
        gson = new Gson();
    }
    public  void  kaisi()
    {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("type", "1")
                .build();
        final Request request=new Request.Builder().url(Uri.shouye).get().build();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                ks.onFaill(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求成功
              String jie=    response.body().string();
                ks.onSucces(jie);
            }
        });
    }
    public void MoText(OKjiekouchuan ks) {
        this.ks = ks;
    }


}
