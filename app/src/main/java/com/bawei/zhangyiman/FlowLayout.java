package com.bawei.zhangyiman;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 *@auther:张奕漫
 *@Date: 2019/12/10
 *@Time:13:40
 *@Description:
 * */
public class FlowLayout extends ViewGroup {
    int screenWid = 0;
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWid = displayMetrics.widthPixels;
    }
    //摆放子View,可以控制子View的位置
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //两个孩子之间的 横向的空隙
//        int wSpace = 30;
        int wSpace = 30;
        //两行之间上下的空隙
        int hSpace = 30;
        int left = wSpace;
        int right =0;
        int top = hSpace;
        int bottom = 0;


        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.measure(0,0);

            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
            right = left+measuredWidth;
            if (right<screenWid){
                bottom = top+measuredHeight;
            }else{
                left = wSpace;
                top =bottom + hSpace;
                right = left + measuredWidth;
                bottom = top + measuredHeight;

            }
            child.layout(left,top,right,bottom);
            left = right + wSpace;
        }
    }
    public void addTag(String tag){
        final TextView textView = new TextView(getContext());
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTagClickListener != null) {
                    onTagClickListener.onTagClick(textView.getText().toString());
                }
            }
        });
        textView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //移除view
                removeView(textView);
                if (onTagLongClickListener != null) {
                    onTagLongClickListener.onTagLongClick(textView.getText().toString());
                }
                return true;
            }
        });

        textView.setText(tag);
        textView.setTextColor(Color.GREEN);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.RED);
        //给流式布局添加子view
        addView(textView);
    }

    onTagClickListener onTagClickListener;

    public void setOnTagClickListener(FlowLayout.onTagClickListener onTagClickListener) {
        this.onTagClickListener = onTagClickListener;
    }

    public interface onTagClickListener {
        void onTagClick(String tag);
    }

    onTagLongClickListener onTagLongClickListener;

    public void setOnTagLongClickListener(FlowLayout.onTagLongClickListener onTagLongClickListener) {
        this.onTagLongClickListener = onTagLongClickListener;
    }

    public interface onTagLongClickListener {
        void onTagLongClick(String tag);
    }

}
