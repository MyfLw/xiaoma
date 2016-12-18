package com.bwei.yunifang.view.Not;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bwei.yunifang.view.Bean.BaseBean;

/**
 *  * 作者：19084 on 2016/12/9 19:04
 *  * 邮箱：xjs250@163.com
 *  
 */
public class HttpUtils  {

    private static HttpUtils httpUtils;
    private RequestQueue requestQueue;
  //私有化构造
    private HttpUtils(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }
   //单例模式
    public static HttpUtils getHttpUtils(Context context) {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils(context);
                    Log.d("HttpUtils","走了");
                }
            }
        }
        return httpUtils;
    }

    public void requestGet(String url, Class clazz, final ANdebuk callBack) {

        GsonRequest requestGet = new GsonRequest(url, clazz, new Response.Listener<BaseBean>() {

            @Override
            public void onResponse(BaseBean response) {

                    callBack.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                callBack.onFail();
            }
        });
        requestQueue.add(requestGet);
    }

}
