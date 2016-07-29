package com.example.maimenghuo.framents;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.maimenghuo.R;
import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.GoodsListAdapter;
import com.example.maimenghuo.bean.GoodsEntry;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
public class DiscoveryGoodsFragment extends Fragment {

    private View view;
    private ListView listView;
    private GoodsListAdapter listAdapter;

    public DiscoveryGoodsFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_discovery_goods, container, false);
        initView();
        initData();
        return view;
    }

    private void initView() {
        listView = (ListView) view.findViewById(R.id.gooods_listView);
        listAdapter = new GoodsListAdapter(getActivity());
        listView.setAdapter(listAdapter);
    }
    private void initData() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(UriUtil.GOODS_URI)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json= response.body().string();
                if (!TextUtils.isEmpty(json)){
                    Gson gson=new Gson();
                    GoodsEntry goodsEntry = gson.fromJson(json, GoodsEntry.class);
                    final List<GoodsEntry.DataBean.CategoriesBean> categories = goodsEntry.getData().getCategories();
                    if (categories != null) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                listAdapter.setData(categories);
                            }
                        });
                    }

                }
            }
        });
    }
}
