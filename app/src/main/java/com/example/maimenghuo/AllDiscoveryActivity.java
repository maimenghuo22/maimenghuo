package com.example.maimenghuo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;

import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.AllDiscoveryListAdapter;
import com.example.maimenghuo.bean.AllDiscoveryEntry;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AllDiscoveryActivity extends AppCompatActivity {

    private ListView listView;
    private AllDiscoveryListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_discovery);
        listView = (ListView) findViewById(R.id.allDiscovery_LV);
        listAdapter = new AllDiscoveryListAdapter(this);
        listView.setAdapter(listAdapter);
        initData();
    }

    private void initData() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(UriUtil.DISCOVERY_URI).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if(!TextUtils.isEmpty(json)){
                    Gson gson=new Gson();
                    AllDiscoveryEntry allDiscoveryEntry = gson.fromJson(json, AllDiscoveryEntry.class);
                    final List<AllDiscoveryEntry.DataBean.CollectionsBean> collections = allDiscoveryEntry.getData().getCollections();
                    if (collections != null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    listAdapter.setData(collections);
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
}
