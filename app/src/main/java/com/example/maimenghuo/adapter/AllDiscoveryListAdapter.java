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

import com.example.maimenghuo.DiscoveryActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.AllDiscoveryEntry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class AllDiscoveryListAdapter extends BaseAdapter {
    private List<AllDiscoveryEntry.DataBean.CollectionsBean> data;
    private Context context;
    private LayoutInflater inflater;

    public AllDiscoveryListAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<AllDiscoveryEntry.DataBean.CollectionsBean> data) {
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
            convertView=inflater.inflate(R.layout.all_discovery_list_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        AllDiscoveryEntry.DataBean.CollectionsBean collectionsBean = data.get(position);
        String cover_image_url =collectionsBean.getCover_image_url();
        if (!TextUtils.isEmpty(cover_image_url)){
            Picasso.with(context).load(cover_image_url).config(Bitmap.Config.RGB_565)
                    .into(holder.cover);
        }
        final String title = collectionsBean.getTitle();
        if (!TextUtils.isEmpty(title)){
           holder.title.setText(title);
        }
        String subtitle = collectionsBean.getSubtitle();
        if (!TextUtils.isEmpty(subtitle)){
           holder.subTitle.setText(subtitle);
        }
        final int id = collectionsBean.getId();
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DiscoveryActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("title",title);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    static class ViewHolder{
        TextView title,subTitle;
        ImageView cover;
        public ViewHolder(View itemView) {
            title=(TextView) itemView.findViewById(R.id.allDiscoveryList_title);
            subTitle=(TextView) itemView.findViewById(R.id.allDiscoveryList_subtitle);
            cover=(ImageView) itemView.findViewById(R.id.allDiscoveryList_IV);
        }
    }
}
