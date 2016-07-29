package com.example.maimenghuo.framents;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.maimenghuo.AllDiscoveryActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.DiscoveryGridAdapter;
import com.example.maimenghuo.adapter.DiscoveryListAdapter;
import com.example.maimenghuo.bean.DiscoveryItemEntry;
import com.example.maimenghuo.bean.HotDiscoveryEnty;
import com.example.maimenghuo.customView.GridViewForScrollView;
import com.example.maimenghuo.customView.ListViewForScrollView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryItemFragment extends Fragment {


    private View view;
    private LinearLayout moreLayout;
    private GridViewForScrollView hotGridView;
    private DiscoveryGridAdapter gridAdapter;
    private ListViewForScrollView listView;
    private DiscoveryListAdapter listAdapter;

    public DiscoveryItemFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_discovery_item, container, false);
        initView();
        initGridData();
        initListData();
        return view;
    }


    private void initView() {
        //热门攻略
        hotGridView = (GridViewForScrollView) view.findViewById(R.id.hotGridView);
        gridAdapter=new DiscoveryGridAdapter(getActivity());
        hotGridView.setAdapter(gridAdapter);
        //listview
        listView = (ListViewForScrollView) view.findViewById(R.id.discovery_item_listView);
        listAdapter = new DiscoveryListAdapter(getActivity());
        listView.setAdapter(listAdapter);
        //查看更多和点击事件
        moreLayout = (LinearLayout) view.findViewById(R.id.more_layout);
        moreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AllDiscoveryActivity.class);
                startActivity(intent);
            }
        });

    }
    private void initListData() {
        OkHttpClient httpClient=new OkHttpClient();
        Request request=new Request.Builder().url(UriUtil.DISCOVERYITEM_URI).build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json=response.body().string();
                if (json != null) {
                    Gson gson=new Gson();
                    DiscoveryItemEntry discoveryItemEntry = gson.fromJson(json, DiscoveryItemEntry.class);
                    final List<DiscoveryItemEntry.DataBean.ChannelGroupsBean> groups = discoveryItemEntry.getData().getChannel_groups();
                    if (groups != null) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                listAdapter.setData(groups);
                            }
                        });
                    }
                }
            }
        });
    }


    private void initGridData() {
        OkHttpClient httpClient=new OkHttpClient();
        Request request=new Request.Builder().url(UriUtil.HOT_DISCOVERY_URI).build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json=response.body().string();
                if (json != null) {
                    Gson gson=new Gson();
                    HotDiscoveryEnty hotDiscoveryEnty = gson.fromJson(json, HotDiscoveryEnty.class);
                    List<HotDiscoveryEnty.DataBean.CollectionsBean> collections = hotDiscoveryEnty.getData().getCollections();
                    if (collections != null) {
                        final List<HotDiscoveryEnty.DataBean.CollectionsBean> data =new ArrayList<HotDiscoveryEnty.DataBean.CollectionsBean>();
                        for (int i = 0; i < 4; i++) {
                            data.add(collections.get(i));
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                gridAdapter.setData(data);
                            }
                        });
                    }
                }
            }
        });
    }
}
