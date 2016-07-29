package com.example.maimenghuo.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/26.
 */
public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int layoutW=getWidth();
        int left=0;//起始位置
        int top=0;//
        int maxHeight=0;
        for (int i = 0; i <childCount ; i++) {
            View view=getChildAt(i);
            int w=view.getMeasuredWidth();
            int h=view.getMeasuredHeight();
            MarginLayoutParams lp= (MarginLayoutParams) view.getLayoutParams();
            int bottomMargin = lp.bottomMargin;
            int topMargin = lp.topMargin;
            Log.e("TAG", "onLayout:=="+topMargin);
            int rightMargin = lp.rightMargin;
            int leftMargin = lp.leftMargin;
            left+=leftMargin;
            top+=topMargin;
            int right=left+w;
            int bootom=top+h;
            if(right>layoutW){
                left=leftMargin;
                if((h+topMargin+bottomMargin)>=maxHeight){
                    top=bootom+bottomMargin-(maxHeight-(h+topMargin+bottomMargin))+topMargin;
                }else{
                    top=bootom+bottomMargin+(maxHeight-(h+topMargin+bottomMargin))+topMargin;
                }
                maxHeight=h+topMargin+bottomMargin;
                right=left+w;
                bootom=top+h;
            }else{
                maxHeight=Math.max(maxHeight,h+topMargin+bottomMargin);
            }
            view.layout(left,top,right,bootom);
            left=right+rightMargin;
            top=top-topMargin;
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获得它的父容器为它设置的测量模式和大小
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int childCount = getChildCount();
        int maxHeight=0;
        int heightCount=0;
        int widthCount=0;
        for (int i = 0; i <childCount ; i++) {
            View view=getChildAt(i);
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
            int w=view.getMeasuredWidth();
            int h=view.getMeasuredHeight();
            MarginLayoutParams lp= (MarginLayoutParams) view.getLayoutParams();
            int bottomMargin = lp.bottomMargin;
            int topMargin = lp.topMargin;
            int rightMargin = lp.rightMargin;
            int leftMargin = lp.leftMargin;
            widthCount=widthCount+w+rightMargin+leftMargin;
            if(widthCount>sizeWidth){
                widthCount=0+w+rightMargin+leftMargin;
                heightCount+=maxHeight;
                maxHeight=h+topMargin+bottomMargin;
            }else{
                maxHeight=Math.max(maxHeight,h+topMargin+bottomMargin);
                if (i==childCount-1){
                    heightCount+=maxHeight;
                }
            }
        }
        setMeasuredDimension(widthMeasureSpec, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight
                : heightCount);

    }
}
