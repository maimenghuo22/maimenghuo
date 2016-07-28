package com.example.maimenghuo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.Posts;
import com.example.maimenghuo.bean.Titles;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lvcuili on 2016/7/28.
 */
public class GuideAdapter extends BaseAdapter {
    private List<Titles.DataBean.PostsBean> data;
    private Context mContext;
    public GuideAdapter(Context mContext,  List<Titles.DataBean.PostsBean> data) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView== null) {
            convertView= LayoutInflater.from(mContext).inflate(R.layout.title_item,parent,false);
            vh=new ViewHolder();
            vh.iv= (ImageView) convertView.findViewById(R.id.lv_title);
            vh.tv= (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(vh);

        }else {
            vh= (ViewHolder) convertView.getTag();
        }
       Titles.DataBean.PostsBean bean=data.get(position);
        String title=bean.getTitle();
        vh.tv.setText(title);
        String path=bean.getCover_image_url();
        Picasso.with(mContext).load(path).config(Bitmap.Config.RGB_565).into(vh.iv);
        return convertView;
    }
    static class ViewHolder{
        TextView tv;
        ImageView iv;
    }
}
