package com.example.maimenghuo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.ItemDiscoveryListAdapter;
import com.example.maimenghuo.bean.ItemDiscoveryEntry;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DiscoveryActivity extends AppCompatActivity {

    private ListView listView;
    private ItemDiscoveryListAdapter listAdapter;
    private int id;
    private String title;
    private TextView titleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);
        id = getIntent().getIntExtra("id",0);
        title = getIntent().getStringExtra("title");
        titleTV = (TextView) findViewById(R.id.Discovery_title);
        titleTV.setText(title);

        listView = (ListView) findViewById(R.id.Discovery_LV);
        listAdapter = new ItemDiscoveryListAdapter(this);
        listView.setAdapter(listAdapter);
        initData();
    }

    private void initData() {
        OkHttpClient okHttpClient=new OkHttpClient();
        String uri=String.format(UriUtil.INTODISCOVERY_URI,id);
        Request request=new Request.Builder().url(uri).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if(!TextUtils.isEmpty(json)){
                    Gson gson=new Gson();
                    ItemDiscoveryEntry itemDiscoveryEntry = gson.fromJson(json, ItemDiscoveryEntry.class);
                    final List<ItemDiscoveryEntry.DataBean.PostsBean> posts = itemDiscoveryEntry.getData().getPosts();
                    if (posts != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                listAdapter.setData(posts);
                            }
                        });
                    }
                }
            }
        });
    }

    public void backClick(View view) {
        this.finish();
    }

    public void shareClick(View view) {

    }
}
