package com.bwei.yunifang.view.fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Bean.Imagbean;
import com.bwei.yunifang.view.Not.ANdebuk;
import com.bwei.yunifang.view.Uitls.Uri;
import com.bwei.yunifang.view.activity.Jifen_dixian;
import com.bwei.yunifang.view.activity.Jifen_shangChen;
import com.bwei.yunifang.view.activity.SouYe_HuohuanActivity;
import com.bwei.yunifang.view.activity.Souyegenduo_Activaty;
import com.bwei.yunifang.view.activity.SouyeshangpinActivity;
import com.bwei.yunifang.view.activity.view.SouYe_zhenweiActivity;
import com.bwei.yunifang.view.activity.view.app;
import com.bwei.yunifang.view.adapter.HomebaseAdapter;
import com.bwei.yunifang.view.adapter.LunBoAdapter;
import com.bwei.yunifang.view.adapter.RecyclerviewAdapert;
import com.bwei.yunifang.view.adapter.ShouyezuihouGrdview;
import com.bwei.yunifang.view.adapter.YouhuiSouyeAdapter;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayuefeng on 2016/12/6.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
   // private

    private final int No1=1;
    private final int No2=2;
    private final int No3=3;
    private final int No4=4;
    private final int No5=5;
    private GridView gridview;
    private ViewPager  youhuiviewopager;
    private ViewPager lunbo;
    private  ArrayList<ImageView> youhuilist=new ArrayList<>();
    private   ArrayList<ImageView> imageViews = new ArrayList<>();
    private  Handler handler = new Handler() {

        private int currentItem;
        private List<Imagbean.DataBean.DefaultGoodsListBean> defaultGoodsList;
        private List<Imagbean.DataBean.SubjectsBean> subjects;
        private Imagbean imaglist;
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==0) {
                currentItem = lunbo.getCurrentItem();
                currentItem++;
                lunbo.setCurrentItem(currentItem);
                autoPlay();
            }
                 if(msg.what==No1) {
                    Imagbean imaglist;   imaglist = (Imagbean) msg.obj;

                     for (int i = 0; i < imaglist.getData().getAd1().size(); i++) {

                         ImageView imageView = new ImageView(getActivity());
                         imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                         x.image().bind(imageView, imaglist.getData().getAd1().get(i).getImage());
                         imageViews.add(imageView);
                     }
                     lunbo.setAdapter(new LunBoAdapter(getActivity(), imageViews));
                   autoPlay();
                 }else  if(msg.what==No2) {
                     Imagbean imaglist= (Imagbean) msg.obj;
                     gridview.setAdapter(new HomebaseAdapter(getContext(), imaglist.getData().getAd5()));
                      gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                          @Override
                          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    switch (i)
                                    {
                                        case 2:
                                              Tiao(getActivity(), SouYe_HuohuanActivity.class);
                                            break;
                                        case  1:
                                            Tiao(getActivity(), Jifen_shangChen.class);
                                            break;
                                        case  3:
                                            Tiao(getActivity(), SouYe_zhenweiActivity.class);
                                            break;
                                        case  5:
                                            Tiao(getActivity(), Jifen_dixian.class);
                                            break;
                                        case 0:
                                            Tiao(getActivity(), SouYe_zhenweiActivity.class);
                                            break;
                                        case  4:
                                            Tiao(getActivity(), Jifen_dixian.class);
                                            break;
                                        case 6:
                                            Tiao(getActivity(), SouYe_zhenweiActivity.class);
                                            break;
                                        case 7:
                                            Tiao(getActivity(), Jifen_dixian.class);
                                            break;



                                    }
                          }
                      });

                 } else if (msg.what==No3)
                 {
                     Imagbean imaglist= (Imagbean) msg.obj;
                     for (int i = 0; i < imaglist.getData().getActivityInfo().getActivityInfoList().size(); i++) {

                         ImageView imageView = new ImageView(getActivity());
                         imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                         x.image().bind(imageView,imaglist.getData().getActivityInfo().getActivityInfoList().get(i).getActivityImg());
                         youhuilist.add(imageView);
                     }
                  youhuiviewopager.setAdapter(new YouhuiSouyeAdapter(getContext(),youhuilist));
                 }
            else if(msg.what==No4)
                 {
                     Imagbean imaglist= (Imagbean) msg.obj;
                     imgrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                     imgrecycler.setItemAnimator(new DefaultItemAnimator());
                     subjects = imaglist.getData().getSubjects();
                     imgrecycler.setAdapter(new RecyclerviewAdapert(getActivity(),subjects,getActivity()));
                        
                 }
            else  if(msg.what==No5){
                     Imagbean imaglist= (Imagbean) msg.obj;
                     defaultGoodsList = imaglist.getData().getDefaultGoodsList();
                          grde.setAdapter(new ShouyezuihouGrdview(getContext(),defaultGoodsList));
                     grde.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                         private String watermarkUrl;
                         private String efficacy;
                         private double shop_price;
                         private double market_price;
                         private String goods_img;
                         private String goods_name;

                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                             Intent  ito=new Intent();

                             ito.setClass(getActivity(), SouyeshangpinActivity.class);
                             ito.putExtra("id",defaultGoodsList.get(i).getId());
                               startActivity(ito);
                         }
                     });
                 }

        }
    };
    private ImageView imgShouye;
    private RecyclerView imgrecycler;
    private GridView grde;
    private Button souyexianshigenduo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment_home,null);
        souyexianshigenduo = (Button) view.findViewById(R.id.Souyexianshigenduo);
        lunbo = (ViewPager) view.findViewById(R.id.lunbo);
        youhuiviewopager = (ViewPager) view.findViewById(R.id.youhuiviewopager);
        imgrecycler = (RecyclerView) view.findViewById(R.id.Imgrecycler);
        grde = (GridView) view.findViewById(R.id.gridviewzuihou);
       souyexianshigenduo.setOnClickListener(this);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获得控件的方法
         Init();
    }

    private void Init() {
        //gridview的控件

        gridview = (GridView) getView().findViewById(R.id.gridview);
            app.httpUtils.requestGet(Uri.shouye, Imagbean.class, new ANdebuk() {


                private Message obtainobtain2;
                private Message obtain1;
                private Message obtain;
                public  Imagbean subBean;

                @Override
                public void onSuccess(BaseBean bean) {
                    Mes1(bean);
                    Mes2(bean);
                    Mes3(bean);
                    Mes4(bean);
                    Mes5(bean);
                }



                @Override
                public void onSuccess_Fail() {
                    Log.e("sa","ds");
                }

                @Override
                public void onFail() {
                    Log.e("fs","kais");
                }
            });
    }
    private void Mes2(BaseBean bean) {
        Message obtain= Message.obtain();
        obtain.what=No2;
        obtain.obj=bean;
        handler.sendMessage(obtain);
    }

    private void Mes1(BaseBean bean) {
        Message obtain= Message.obtain();
        obtain.what=No1;
        obtain.obj=bean;
        handler.sendMessage(obtain);
    }
    private void Mes3(BaseBean bean) {
        Message obtain= Message.obtain();
        obtain.what=No3;
        obtain.obj=bean;
        handler.sendMessage(obtain);
    }
    private void Mes4(BaseBean bean) {
        Message obtain= Message.obtain();
        obtain.what=No4;
        obtain.obj=bean;
        handler.sendMessage(obtain);
    }
    private void Mes5(BaseBean bean) {
        Message obtain= Message.obtain();
        obtain.what=No5;
        obtain.obj=bean;
        handler.sendMessage(obtain);
    }
    private void autoPlay()
    {
      /*  new Thread() {
            @Override
            public void run() {
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        }.start();*/
        handler.sendEmptyMessageDelayed(0, 2000);
    }
    public void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }
  public  void Tiao(Context context, Class cals)
  {
      Intent it=new Intent();
        it.setClass(context,cals);
        startActivity(it);
  }

    @Override
    public void onClick(View view) {
         switch (view.getId())
                 {
                     case R.id.Souyexianshigenduo :
                         Tiao(getContext(),Souyegenduo_Activaty.class);
                     break;

                 }
    }
}
