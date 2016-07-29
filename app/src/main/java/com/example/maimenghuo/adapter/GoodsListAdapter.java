package com.example.maimenghuo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maimenghuo.GoodsItemActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.GoodsEntry;
import com.example.maimenghuo.customView.FlowLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class GoodsListAdapter extends BaseAdapter {
    private List<GoodsEntry.DataBean.CategoriesBean> data;
    private Context context;
    private LayoutInflater inflater;

    public GoodsListAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<GoodsEntry.DataBean.CategoriesBean> data) {
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
            convertView=inflater.inflate(R.layout.goods_list_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        GoodsEntry.DataBean.CategoriesBean bean = data.get(position);
        final int id = bean.getId();
        final String parentName = bean.getName();
        String icon_url = bean.getIcon_url();
        if (!TextUtils.isEmpty(icon_url)) {
            Picasso.with(context).load(icon_url).config(Bitmap.Config.RGB_565)
                    .into(holder.icon);
        }
        final List<GoodsEntry.DataBean.CategoriesBean.SubcategoriesBean> subcategories = bean.getSubcategories();
        if (subcategories != null) {
            for (int i = 0; i < subcategories.size(); i++) {
                final GoodsEntry.DataBean.CategoriesBean.SubcategoriesBean subcategoriesBean = subcategories.get(i);
                String name = subcategoriesBean.getName();
                if(!TextUtils.isEmpty(name)){
                    TextView textView=new TextView(context);
                    ViewGroup.MarginLayoutParams layoutParams=new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                   layoutParams.topMargin=30;
                   layoutParams.leftMargin=30;
                    textView.setLayoutParams(layoutParams);
                    textView.setText(name);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(context, GoodsItemActivity.class);
                            Bundle bundle=new Bundle();
                            bundle.putSerializable("subcategoriesBean",subcategoriesBean);
                            intent.putExtra("index",2);
                            intent.putExtra("bundle",bundle);
                            context.startActivity(intent);
                        }
                    });
                    holder.flowLayout.addView(textView);
                }
            }
        }
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, GoodsItemActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("parentName",parentName);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    static class ViewHolder{
        ImageView icon;
        FlowLayout flowLayout;

        public ViewHolder(View itemView) {
            icon=(ImageView) itemView.findViewById(R.id.gooods_list_IV);
            flowLayout= (FlowLayout) itemView.findViewById(R.id.gooods_list_FL);
        }
    }
}
