package com.example.maimenghuo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.maimenghuo.GuideActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.bean.Banner;
import com.example.maimenghuo.bean.Banners;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvcuili on 2016/7/26.
 */
public class HeadPagerAdapter extends PagerAdapter{
    private Context mContext;
    private List<Banner.DataBean.BannersBean> data;

    private List<ImageView> mImageViews;

    public HeadPagerAdapter(Context mContext) {
      this.mContext=mContext;
        data=new ArrayList<>();
        mImageViews=new ArrayList<>();

    }
    public  void setData(List<Banner.DataBean.BannersBean> data){
       this.data=data;

        for (int i = 0; i <data.size() ; i++) {
         ImageView  iv=new ImageView(mContext);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageViews.add(iv);

        }
        notifyDataSetChanged();

    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView image=mImageViews.get(position);

        Banner.DataBean.BannersBean bean=data.get(position);
        String path=bean.getImage_url();
        if (path != null) {
            Picasso.with(mContext).load(path).error(R.mipmap.ic_launcher)
                    .config(Bitmap.Config.RGB_565)
                   .into(image);

        }
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = data.get(position).getTarget().getId();
                String title=data.get(position).getTarget().getTitle();
                Intent intent=new Intent(mContext, GuideActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("title",title);
                mContext.startActivity(intent);

            }
        });
        container.addView(image);
        return image;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView(mImageViews.get(position));
    }
}
