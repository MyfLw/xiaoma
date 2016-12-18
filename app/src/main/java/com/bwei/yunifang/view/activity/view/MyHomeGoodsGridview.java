package com.bwei.yunifang.view.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by 55081 on 2016/12/12.
 */

public class MyHomeGoodsGridview extends GridView {
    public MyHomeGoodsGridview(Context context) {
        super(context);
    }

    public MyHomeGoodsGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHomeGoodsGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2 ,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
