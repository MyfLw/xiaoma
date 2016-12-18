package com.bwei.yunifang.view.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

/**
 *  * 作者：19084 on 2016/12/13 18:37
 *  * 邮箱：xjs250@163.com
 *  
 */
public class Girdeview extends GridView {
    public Girdeview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Girdeview(Context context) {
        super(context);
    }

    public Girdeview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
