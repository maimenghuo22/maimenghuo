package com.example.maimenghuo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.bean.DiscoveryDetailEntry;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ToolActivity extends AppCompatActivity {
    private WebView mWebView;
    private int id;
    private TextView likeTV;
    private TextView msgTV;
    private TextView shareTV;
    private String content_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool);
        Intent intent=getIntent();
        id = intent.getIntExtra("id",0);
        content_url = intent.getStringExtra("content_url");
        likeTV = (TextView) findViewById(R.id.discoveryDetail_likeNum);
        msgTV = (TextView) findViewById(R.id.discoveryDetail_msgNum);
        shareTV = (TextView) findViewById(R.id.discoveryDetail_shareNum);

        mWebView= (WebView) findViewById(R.id.web_tool);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        initData();
        //http://www.maimenghuo.com/items/6525
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private void initData() {
        OkHttpClient okHttpClient=new OkHttpClient();
        String path=String.format(UriUtil.DISCOVERY_DETAIL_URI,id);
        Request request=new Request.Builder().url(path).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if(!TextUtils.isEmpty(json)){
                    Gson gson=new Gson();
                    DiscoveryDetailEntry discoveryDetailEntry = gson.fromJson(json, DiscoveryDetailEntry.class);
                    final DiscoveryDetailEntry.DataBean dataBean = discoveryDetailEntry.getData();
                    if (dataBean != null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    int comments_count = dataBean.getComments_count();
                                    msgTV.setText(comments_count+"");
                                    int likes_count = dataBean.getLikes_count();
                                    likeTV.setText(likes_count+"");
                                    int shares_count = dataBean.getShares_count();
                                    shareTV.setText(shares_count+"");
                                    mWebView.loadDataWithBaseURL(null,dataBean.getContent_html(),"text/html","utf-8",null);
                                }
                            });
                    }
                }
            }
        });
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_tool_back:
                finish();
                break;


        }
    }

    public void messageClick(View view) {//评论
    }

    public void shareClick(View view) {//分享
    }

    public void likeClick(View view) {//喜欢
    }
}
