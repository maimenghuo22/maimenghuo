package com.example.maimenghuo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maimenghuo.NewsActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.ToolActivity;
import com.example.maimenghuo.bean.Posts;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lvcuili on 2016/7/26.
 */
public class MainAdapter extends BaseAdapter {
    private Context mContext;
    private List<Posts.DataBean.PostsBean> data;

    public MainAdapter(Context mContext, List<Posts.DataBean.PostsBean> data) {
        this.mContext=mContext;
        this.data=data;

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
    public View getView(final int position, View convertView, ViewGroup parent) {
       ViewHolder vh;

        if (convertView==null) {
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_fragment,parent,false);
            vh=new ViewHolder();
            vh.iv1= (ImageView) convertView.findViewById(R.id.iv_home_fragemnt);
            vh.iv1.setScaleType(ImageView.ScaleType.FIT_XY);
            vh.layout= (LinearLayout) convertView.findViewById(R.id.linear);
            convertView.setTag(vh);

        }else {
            vh= (ViewHolder) convertView.getTag();

        }
        final Posts.DataBean.PostsBean  bean=data.get(position) ;




        vh.layout.removeAllViews();
        for (int i = 0; i <bean.getPost_items().size() ; i++) {
            View v1=LayoutInflater.from(mContext).inflate(R.layout.scollview_item, vh.layout,false);
            ImageView iv= (ImageView) v1.findViewById(R.id.iv_item_01);
            TextView tvName= (TextView) v1.findViewById(R.id.tv_name);
            TextView tvPrice= (TextView) v1.findViewById(R.id.tv_price);
            vh.layout.addView(v1);
            tvPrice.setText("￥"+bean.getPost_items().get(i).getPrice());
            tvName.setText(bean.getPost_items().get(i).getName());
            String path2=bean.getPost_items().get(i).getCover_image_url();
            Picasso.with(mContext).load(path2).resize(120,140).centerCrop().config(Bitmap.Config.RGB_565).into(iv);


        }
        vh.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=bean.getPost_items().get(position).getUrl();
                Intent intent=new Intent(mContext, NewsActivity.class);
                intent.putExtra("url",url);
                mContext.startActivity(intent);
            }
        });


        String path1=bean.getCover_image_url();

        Picasso.with(mContext).load(path1).resize(300,180).config(Bitmap.Config.RGB_565).into(vh.iv1);
        vh.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toolUrl=bean.getContent_url();
                Intent intent=new Intent(mContext, ToolActivity.class);
                intent.putExtra("toolUrl",toolUrl);
                mContext.startActivity(intent);


            }
        });

        return convertView;

    }
    class ViewHolder{
        ImageView iv1;
        LinearLayout layout;
    }
}
