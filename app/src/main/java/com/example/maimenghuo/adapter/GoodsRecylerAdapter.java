package com.example.maimenghuo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maimenghuo.NewsActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.GoodsItemEntry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class GoodsRecylerAdapter extends RecyclerView.Adapter<GoodsRecylerAdapter.ViewHolder> {
    private Context context;
    private List<GoodsItemEntry.DataBean.ItemsBean> data;
    private LayoutInflater inflater;

    public GoodsRecylerAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<GoodsItemEntry.DataBean.ItemsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.goods_recyler_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GoodsItemEntry.DataBean.ItemsBean itemsBean = data.get(position);
        String image_url = itemsBean.getCover_image_url();
        if(!TextUtils.isEmpty(image_url)){
            Picasso.with(context)
                    .load(image_url)
                    .config(Bitmap.Config.RGB_565)
                    .into(holder.cover);
        }
        String name = itemsBean.getName();
        holder.name.setText(name);
        int favorites_count = itemsBean.getFavorites_count();
        holder.favoritesCount.setText(favorites_count+"");
        String price = itemsBean.getPrice();
        holder.price.setText("￥"+price);
        final int id = itemsBean.getId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsActivity.class);
                intent.putExtra("id",id);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cover;
        TextView name,price,favoritesCount;
        public ViewHolder(View itemView) {
            super(itemView);
            cover=(ImageView) itemView.findViewById(R.id.gooodsItem_IV);
            name= (TextView) itemView.findViewById(R.id.gooodsItem_name);
            price= (TextView) itemView.findViewById(R.id.gooodsItem_price);
            favoritesCount= (TextView) itemView.findViewById(R.id.goodsItem_favorites_count);
        }
    }
}
