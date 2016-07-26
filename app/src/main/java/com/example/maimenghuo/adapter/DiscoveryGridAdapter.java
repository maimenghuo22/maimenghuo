package com.example.maimenghuo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.HotDiscoveryEnty;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class DiscoveryGridAdapter extends BaseAdapter {
    private List<HotDiscoveryEnty.DataBean.CollectionsBean> data;
    private Context context;
    private LayoutInflater inflater;

    public DiscoveryGridAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<HotDiscoveryEnty.DataBean.CollectionsBean> data) {
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
            convertView=inflater.inflate(R.layout.secondly_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        String imagePath=data.get(position).getBanner_image_url();
        if (!TextUtils.isEmpty(imagePath)) {
            Picasso.with(context)
                    .load(imagePath)
                    .config(Bitmap.Config.RGB_565)
                    .into(holder.iv);
        }
        return convertView;
    }
    static class ViewHolder{
        ImageView iv;
        public ViewHolder(View itemView) {
            iv=(ImageView) itemView.findViewById(R.id.item_imageView);
        }
    }
}
