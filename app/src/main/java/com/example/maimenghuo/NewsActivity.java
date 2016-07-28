package com.example.maimenghuo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class NewsActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mWebView= (WebView) findViewById(R.id.web_news);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        mWebView.loadUrl(url);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_news_back:
                finish();
                break;
            case R.id.btn_news_share:
                break;
        }
    }
}
