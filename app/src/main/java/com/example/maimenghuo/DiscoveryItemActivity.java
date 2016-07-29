package com.example.maimenghuo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.DiscoveryItemListAdapter;
import com.example.maimenghuo.bean.DiscoveryTabEntry;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DiscoveryItemActivity extends AppCompatActivity {

    private String name;
    private int id;
    private TextView titleTV;
    private ListView listView;
    private DiscoveryItemListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery_item);
        name = getIntent().getStringExtra("name");
        id = getIntent().getIntExtra("id", 0);
        titleTV = (TextView) findViewById(R.id.DiscoveryItem_title);
        titleTV.setText(name);

        listView = (ListView) findViewById(R.id.DiscoveryItem_LV);
        listAdapter = new DiscoveryItemListAdapter(this);
        listView.setAdapter(listAdapter);

        initData();
    }

    private void initData() {
        OkHttpClient okHttpClient=new OkHttpClient();
        String uri=String.format(UriUtil.INTODISCOVERYITEM_URI,id);
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
                    DiscoveryTabEntry discoveryTabEntry = gson.fromJson(json, DiscoveryTabEntry.class);
                    final List<DiscoveryTabEntry.DataBean.ItemsBean> items = discoveryTabEntry.getData().getItems();
                    if (items != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                listAdapter.setData(items);
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

    public void sortClick(View view) {
    }
}
