package com.bwei.yunifang.view.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.yunifang.R;
import com.bwei.yunifang.view.Bean.BaseBean;
import com.bwei.yunifang.view.Bean.GoodsInfoBean;
import com.bwei.yunifang.view.Database.SQLItegouwu;
import com.bwei.yunifang.view.Not.ANdebuk;
import com.bwei.yunifang.view.Uitls.Uri;
import com.bwei.yunifang.view.activity.view.app;
import com.bwei.yunifang.view.adapter.ImageAdapter;

import org.xutils.x;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 *  * 作者：19084 on 2016/12/13 20:24
 *  * 邮箱：xjs250@163.com
 *  
 */
public class SouyeshangpinActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SouyeshangpinActivity";
    private Intent intent;
    private TextView goods_title;
    private TextView goods_price;
    private TextView goods_oldprice;
    private TextView kefu;
    private TextView add_shop;
    private TextView buy;
    private ViewPager viewPager;
    private String encode;
    private String id;
    public SQLItegouwu sqlItegouwu;
    private TextView collect;
    private TextView sales;
    private ContentValues contentValues;
    private SQLiteDatabase readableDatabase;
    public GoodsInfoBean goods;
    private Handler handler = new Handler() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void handleMessage(Message msg) {
            goods = (GoodsInfoBean) msg.obj;
            List<GoodsInfoBean.DataBean.GoodsBean.GalleryBean> gallery = goods.getData().getGoods().getGallery();
            ArrayList<ImageView> imageViews = new ArrayList<>();
            for (int i = 0; i < gallery.size(); i++) {
                ImageView imageView = new ImageView(SouyeshangpinActivity.this);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                x.image().bind(imageView, gallery.get(i).getNormal_url());
                x.image().bind(imageView, gallery.get(i).getOriginal_url());
                x.image().bind(imageView, gallery.get(i).getThumb_url());
                imageViews.add(imageView);
            }
            String efficacy = goods.getData().getGoods().getEfficacy();
            double market_price = goods.getData().getGoods().getMarket_price();
            double shop_price = goods.getData().getGoods().getShop_price();
            final int collect_count = goods.getData().getGoods().getCollect_count();
            int sales_volume = goods.getData().getGoods().getSales_volume();
            goods_title.setText(efficacy);
            goods_oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            goods_price.setText("¥" + shop_price);
            goods_oldprice.setText("¥" + market_price);
            collect.setText(collect_count + "");
            if (sales_volume >= 10000) {
                double dele = sales_volume * 0.0001;
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
                String st = df.format(dele);
                System.out.println(st);
                sales.setText((st) + "万");
            } else if (sales_volume < 10000) {
                double dele = sales_volume * 0.0001;
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
                String st = df.format(dele);
                System.out.println(st);
                sales.setText("0" + (st) + "万");

            }

            viewPager.setAdapter(new ImageAdapter(imageViews));

        }
    };
    private TextView zhegai;
    private TextView num, number, money;
    private Button jian;
    private Button jia;
    private Button ok;
    private int count = 1;
    private ImageView image_goods;
    private PopupWindow popupWindow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wode_shangpinxiangqin);
        sqlItegouwu = new SQLItegouwu(this);
        readableDatabase = sqlItegouwu.getReadableDatabase();

        intent = getIntent();
        id = intent.getStringExtra("id");
        encode = URLEncoder.encode(id);
        initView();
        InItShuju();


    }

    private void InItShuju() {

        app.httpUtils.requestGet(Uri.gshangpin_xiangqin + encode, GoodsInfoBean.class, new ANdebuk() {
            @Override
            public void onSuccess(BaseBean bean) {
                Message message = Message.obtain();
                message.obj = bean;
                handler.sendMessage(message);

            }

            @Override
            public void onSuccess_Fail() {

            }

            @Override
            public void onFail() {

            }
        });
    }

    private void initView() {
        sales = (TextView) findViewById(R.id.sales);
        collect = (TextView) findViewById(R.id.collect);
        viewPager = (ViewPager) findViewById(R.id.goods_img);
        goods_title = (TextView) findViewById(R.id.goods_title);
        goods_price = (TextView) findViewById(R.id.goods_price);
        goods_oldprice = (TextView) findViewById(R.id.goods_oldprice);
        kefu = (TextView) findViewById(R.id.kefu);
        add_shop = (TextView) findViewById(R.id.add_shop);
        buy = (TextView) findViewById(R.id.buy);
        zhegai = (TextView) findViewById(R.id.zhegai);
        kefu.setOnClickListener(this);
        add_shop.setOnClickListener(this);
        buy.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_shop:

                showP(view);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SouyeshangpinActivity.this, "恭喜，添加购物车成功！", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                        readableDatabase = sqlItegouwu.getReadableDatabase();
                        contentValues = new ContentValues();
                        contentValues.put("ProName", goods.getData().getGoods().getGoods_name());
                        contentValues.put("proimg", goods.getData().getGoods().getGoods_img());
                        contentValues.put("shopprice", goods.getData().getGoods().getShop_price() + "");
                        contentValues.put("proCount", count);
                        readableDatabase.insert("gouwuche", null, contentValues);

                    }
                });

                break;
            case R.id.buy:
                showP(view);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(SouyeshangpinActivity.this, DingDanActivity.class));
                        popupWindow.dismiss();
                    }
                });
                break;

            default:
                break;
        }
    }

    private void showP(View view) {
        View v = View.inflate(this, R.layout.jiarugouwuchetanchu, null);
        popupWindow = new PopupWindow(v, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.popu);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                zhegai.setVisibility(View.GONE);
            }
        });
        AlphaAnimation animation = new AlphaAnimation(0, 0.5f);
        animation.setDuration(500);
        zhegai.startAnimation(animation);
        zhegai.setVisibility(View.VISIBLE);

        num = (TextView) v.findViewById(R.id.num);
        jian = (Button) v.findViewById(R.id.jian);
        jia = (Button) v.findViewById(R.id.jia);
        ok = (Button) v.findViewById(R.id.ok);
        number = (TextView) v.findViewById(R.id.number);
        money = (TextView) v.findViewById(R.id.money);
        image_goods = (ImageView) findViewById(R.id.image_goods);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                x.image().bind(image_goods, goods.getData().getGoods().getGoods_img());
            }
        });
        number.setText("库存" + goods.getData().getGoods().getStock_number() + "件");
        money.setText("¥" + goods.getData().getGoods().getShop_price());
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count >= 1 & count < 5) {
                    count++;
                    num.setText(count + "");
                    jian.setTextColor(Color.BLACK);
                    if (count >= 5) {
                        count = 5;
                        num.setText(count + "");
                        jia.setTextColor(Color.GRAY);
                    }
                }
            }
        });

        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 5) {
                    count--;
                    num.setText(count + "");
                    jia.setTextColor(Color.BLACK);
                    if (count <= 1) {
                        count = 1;
                        num.setText(count + "");
                        jian.setTextColor(Color.GRAY);
                    }
                }

            }
        });

    }

}
