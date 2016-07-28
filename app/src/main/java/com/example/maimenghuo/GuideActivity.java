package com.example.maimenghuo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maimenghuo.adapter.GuideAdapter;
import com.example.maimenghuo.bean.Titles;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GuideActivity extends AppCompatActivity {

    private TextView tv;
    private ListView lv;
    private GuideAdapter mAdapter;
    private List<Titles.DataBean.PostsBean> data;
    private String path;
    private Handler handle=new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent it=new Intent();
//                String content_url = data.get(position).getContent_url();
//                it.putExtra("content_url",content_url);
//
//            }
//        });


        Intent intent=getIntent();
        String title = intent.getStringExtra("title");
        tv.setText(title);
        int id=intent.getIntExtra("id",1);
      path="http://api.maimenghuo.com/v2/collections/"+id+"/posts?limit=20&offset=0";


        initData();
        lv.setAdapter(mAdapter);

    }

    private void initData() {
        OkHttpClient okHttp=new OkHttpClient();
        Request request=new Request.Builder().url(path).build();
        Call call=okHttp.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call,  Response response) throws IOException {
                final String urll=response.body().string();
                if (urll != null) {
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson=new Gson();
                            Titles titles=gson.fromJson(urll,Titles.class);
                            data.addAll(titles.getData().getPosts());
                            mAdapter.notifyDataSetChanged();


                        }
                    });

                }


            }
        });
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv_guide_title);
        lv = (ListView) findViewById(R.id.lv_guide);
        data=new ArrayList<>();
        mAdapter=new GuideAdapter(this,data);


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.guide_news_back:
                finish();
        }
    }
}
