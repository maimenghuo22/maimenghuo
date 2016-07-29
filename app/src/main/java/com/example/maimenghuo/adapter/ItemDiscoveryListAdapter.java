package com.example.maimenghuo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maimenghuo.R;
import com.example.maimenghuo.ToolActivity;
import com.example.maimenghuo.bean.ItemDiscoveryEntry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ItemDiscoveryListAdapter extends BaseAdapter {
    private List<ItemDiscoveryEntry.DataBean.PostsBean> data;
    private Context context;
    private LayoutInflater inflater;

    public ItemDiscoveryListAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<ItemDiscoveryEntry.DataBean.PostsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            convertView=inflater.inflate(R.layout.discovery_list_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        ItemDiscoveryEntry.DataBean.PostsBean postsBean = data.get(position);
        int likes_count = postsBean.getLikes_count();
        String title = postsBean.getTitle();
        String cover_image_url = postsBean.getCover_image_url();
        if(!TextUtils.isEmpty(cover_image_url)){
            Picasso.with(context).load(cover_image_url).config(Bitmap.Config.RGB_565)
                    .into(holder.cover);

        }
        holder.likes_count.setText(likes_count+"");

        if(!TextUtils.isEmpty(title)){
            holder.title.setText(title);
        }
        final int id = postsBean.getId();
        final String content_url = postsBean.getContent_url();
        holder.cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ToolActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("content_url",content_url);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    static class ViewHolder{
        TextView title,likes_count;
        ImageView cover;
        public ViewHolder(View itemView) {
            title=(TextView) itemView.findViewById(R.id.discoveryList_title);
            likes_count=(TextView) itemView.findViewById(R.id.favorite_num);
            cover=(ImageView) itemView.findViewById(R.id.discoveryList_IV);
        }
    }
}
