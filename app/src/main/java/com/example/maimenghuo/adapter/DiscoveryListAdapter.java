package com.example.maimenghuo.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.DiscoveryItemEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class DiscoveryListAdapter extends BaseAdapter {
    private List<DiscoveryItemEntry.DataBean.ChannelGroupsBean> data;
    private Context context;
    private LayoutInflater inflater;

    public DiscoveryListAdapter(Context context) {
        this.context = context;
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }

    public void setData(List<DiscoveryItemEntry.DataBean.ChannelGroupsBean> data) {
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
            convertView=inflater.inflate(R.layout.discovery_item_list_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        DiscoveryItemEntry.DataBean.ChannelGroupsBean channelGroupsBean = data.get(position);
        if (channelGroupsBean != null) {
            String name = channelGroupsBean.getName();
            if (!TextUtils.isEmpty(name)) {
                List<DiscoveryItemEntry.DataBean.ChannelGroupsBean.ChannelsBean> channels = channelGroupsBean.getChannels();
                DiscoveryRecylerAdapter recylerAdapter=new DiscoveryRecylerAdapter(context);
                if ("栏目专区".equals(name)){
                    holder.tv.setText("栏目专区");
                    LinearLayoutManager layoutManager=new LinearLayoutManager(context);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    holder.recyclerView.setLayoutManager(layoutManager);
                }else if("攻略标签".equals(name)){
                    holder.tv.setText("攻略标签");
                    GridLayoutManager layoutManager=new GridLayoutManager(context, 2);
                    holder.recyclerView.setLayoutManager(layoutManager);
                }
                holder.recyclerView.setAdapter(recylerAdapter);
                recylerAdapter.setData(channels);
            }
        }
        return convertView;
    }
    static class ViewHolder{
        TextView tv;
        RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            tv=(TextView) itemView.findViewById(R.id.discovery_item_title);
            recyclerView=(RecyclerView) itemView.findViewById(R.id.discovery_item_recyclerView);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    outRect.set(0,0,0,10);
                }
            });
        }
    }
}
