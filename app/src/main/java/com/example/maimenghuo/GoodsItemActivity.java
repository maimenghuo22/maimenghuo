package com.example.maimenghuo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.GoodsRecylerAdapter;
import com.example.maimenghuo.bean.GoodsEntry;
import com.example.maimenghuo.bean.GoodsItemEntry;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoodsItemActivity extends AppCompatActivity {

    private TextView titleTV;
    private int id;
    private String parentName;
    private RecyclerView recyclerView;
    private GoodsEntry.DataBean.CategoriesBean.SubcategoriesBean subcategoriesBean;
    private GoodsRecylerAdapter recylerAdapter;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_item);
        id = getIntent().getIntExtra("id",0);
        parentName = getIntent().getStringExtra("parentName");
        index = getIntent().getIntExtra("index", 0);
        titleTV = (TextView) findViewById(R.id.goodsItem_title);
        recyclerView = (RecyclerView) findViewById(R.id.goodsItemRecyclerView);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recylerAdapter = new GoodsRecylerAdapter(this);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(10,10,10,0);
            }
        });
        recyclerView.setAdapter(recylerAdapter);
        initData();
    }

    private void initData() {
        String path=null;
        if (index!=0) {
            subcategoriesBean= (GoodsEntry.DataBean.CategoriesBean.SubcategoriesBean) getIntent().getBundleExtra("bundle").getSerializable("subcategoriesBean");
            path=String.format(UriUtil.GOODS_ITEM_SUBCATEGORIES_URI,subcategoriesBean.getId());
            titleTV.setText(subcategoriesBean.getName());
        }else{
            path=String.format(UriUtil.GOODS_ITEM_CATEGORIES_URI,id);
            titleTV.setText(parentName);
        }
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder().url(path).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if(!TextUtils.isEmpty(json)){
                    Gson gson=new Gson();
                    GoodsItemEntry goodsItemEntry = gson.fromJson(json, GoodsItemEntry.class);
                    final List<GoodsItemEntry.DataBean.ItemsBean> items = goodsItemEntry.getData().getItems();
                    if (items != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recylerAdapter.setData(items);
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
