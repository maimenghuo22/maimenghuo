package com.example.maimenghuo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.bean.GoodsDetailEntry;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsActivity extends AppCompatActivity {
    private WebView mWebView;
    private int id;
    private TextView titleTV;
    private TextView priceTV;
    private TextView maioshuTV;
    private ViewPager viewPager;
    private LinearLayout layout;
    private TextView jieshaoTV;
    private TextView pinglunTV;
    private ScrollView scrollView;
    int[] location =new int[2];
    int[] location1 =new int[2];
    private LinearLayout dongLayout;
    private LinearLayout jingLayout;
    private LinearLayout headLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent=getIntent();
        id = intent.getIntExtra("id",0);
        initView();
        initData();
    }



    private void initView() {
        mWebView = (WebView) findViewById(R.id.web_news);
        titleTV = (TextView) findViewById(R.id.goodsDetail_title);
        priceTV = (TextView) findViewById(R.id.goodsDetail_price);
        jieshaoTV = (TextView) findViewById(R.id.goodsDetail_jieshao);
        pinglunTV = (TextView) findViewById(R.id.goodsDetail_pinglun);
        maioshuTV = (TextView) findViewById(R.id.goodsDetail_maioshu);
        viewPager = (ViewPager) findViewById(R.id.goodsDetail_VP);
        layout = (LinearLayout) findViewById(R.id.goodsDetail_layout);
        dongLayout = (LinearLayout) findViewById(R.id.goodsDetail_dong);
        jingLayout = (LinearLayout) findViewById(R.id.goodsDetail_jing);
        scrollView = (ScrollView) findViewById(R.id.goodsDetail_SV);
        headLayout = (LinearLayout) findViewById(R.id.headLayout);

        scrollView.setOnTouchListener(new View.OnTouchListener() {

            int lastY = 0;
            int touchEventID = -88888;
            Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == touchEventID) {
                        int scrollY = scrollView.getScrollY();
                        if (scrollY != lastY) {
                            handler.sendMessageDelayed(handler.obtainMessage(touchEventID, scrollView), 5);
                            lastY = scrollY;
                            dongLayout.getLocationOnScreen(location);
                            jingLayout.getLocationOnScreen(location1);
                            if (location[1] <= location1[1]) {
                               if (jieshaoTV.getParent()!=jingLayout&&pinglunTV.getParent()!=jingLayout) {
                                    dongLayout.removeAllViews();
                                    jingLayout.addView(jieshaoTV);
                                    jingLayout.addView(pinglunTV);
                                }
                            }else {
                                if (jieshaoTV.getParent()!=dongLayout&&pinglunTV.getParent()!=dongLayout) {
                                    jingLayout.removeAllViews();
                                    dongLayout.addView(jieshaoTV);
                                    dongLayout.addView(pinglunTV);
                                }
                            }
//                            if (location[1] <= location1[1]) {
//                                jingLayout.setVisibility(View.VISIBLE);
//
//                            }else{
//                                jingLayout.setVisibility(View.GONE);
//                            }
                        }
                    }
                }
            };
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_MOVE){
                    handler.sendMessageDelayed(handler.obtainMessage(touchEventID, v), 5);
                }
                 if (event.getAction()==MotionEvent.ACTION_UP){
                    handler.sendMessageDelayed(handler.obtainMessage(touchEventID, v), 5);
                }

                return false;
            }
        });

    }
    private void initData() {
        OkHttpClient okHttpClient=new OkHttpClient();
        String path=String.format(UriUtil.GOODS_DETAIL_URI,id);
        Request request=new Request.Builder().url(path).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if (!TextUtils.isEmpty(json)) {
                    Gson  gson=new Gson();
                    GoodsDetailEntry goodsDetailEntry = gson.fromJson(json, GoodsDetailEntry.class);
                    final GoodsDetailEntry.DataBean dataBean = goodsDetailEntry.getData();
                    final String name = dataBean.getName();
                    int comments_count = dataBean.getComments_count();
                    final String price = dataBean.getPrice();
                    final String description = dataBean.getDescription();
                    final String detail_html = dataBean.getDetail_html();
                    List<String> image_urls = dataBean.getImage_urls();
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           titleTV.setText(name);
                           priceTV.setText("￥"+price);
                           maioshuTV.setText(description);
                           mWebView.loadDataWithBaseURL(null,detail_html,"text/html","utf-8",null);

                       }
                   });
                }
            }
        });
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_news_back:
                finish();
                break;
            case R.id.btn_news_share:
                break;
            case R.id.goodsDetail_jieshao://图文介绍
                jieshaoTV.setSelected(true);
                pinglunTV.setSelected(false);
                break;
            case R.id.goodsDetail_pinglun://评论
                jieshaoTV.setSelected(false);
                pinglunTV.setSelected(true);
                break;

        }
    }
}
