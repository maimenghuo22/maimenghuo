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

import com.example.maimenghuo.DiscoveryItemActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.DiscoveryItemEntry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class DiscoveryRecylerAdapter extends RecyclerView.Adapter<DiscoveryRecylerAdapter.ViewHolder> {
    private Context context;
    private List<DiscoveryItemEntry.DataBean.ChannelGroupsBean.ChannelsBean> data;
    private LayoutInflater inflater;

    public DiscoveryRecylerAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<DiscoveryItemEntry.DataBean.ChannelGroupsBean.ChannelsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.secondly_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String icon_url = data.get(position).getIcon_url();
        if(!TextUtils.isEmpty(icon_url)){
            Picasso.with(context)
                    .load(icon_url)
                    .config(Bitmap.Config.RGB_565)
                    .into(holder.iv);
        }
        final int id = data.get(position).getId();
        final String name = data.get(position).getName();
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DiscoveryItemActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv=(ImageView) itemView.findViewById(R.id.item_imageView);
        }
    }
}
