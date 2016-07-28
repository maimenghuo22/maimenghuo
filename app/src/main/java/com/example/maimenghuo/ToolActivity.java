package com.example.maimenghuo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class ToolActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tool);
        mWebView= (WebView) findViewById(R.id.web_tool);
        Intent intent=getIntent();
        String url=intent.getStringExtra("toolUrl");
        mWebView.loadUrl(url);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_tool_back:
                finish();
                break;


        }
    }
}
