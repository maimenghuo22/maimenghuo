package com.example.maimenghuo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
    private List<Banners.DataBean.SecondaryBannersBean> mList;
    private List<ImageView> mImageViews,mImageViews2;

    public HeadPagerAdapter(Context mContext) {
      this.mContext=mContext;
        data=new ArrayList<>();

        mImageViews=new ArrayList<>();
        mList=new ArrayList<>();
        mImageViews2=new ArrayList<>();


    }
    public  void setData(List<Banner.DataBean.BannersBean> data){
       this.data=data;


        for (int i = 0; i <data.size() ; i++) {
         ImageView  iv=new ImageView(mContext);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageViews.add(iv);


        }




    }
    public void setData1(List<Banners.DataBean.SecondaryBannersBean> mList){
        this.mList=mList;
        for (int i = 0; i < mList.size(); i++) {
            ImageView  iv2=new ImageView(mContext);
            iv2.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageViews2.add(iv2);


        }
        notifyDataSetChanged();

    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView image=mImageViews.get(position);
        Banner.DataBean.BannersBean bean=data.get(position);
        String path=bean.getImage_url();
        if (path != null) {
            Picasso.with(mContext).load(path).error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher).centerCrop().config(Bitmap.Config.RGB_565)
                    .resize(100,100).into(image);

        }

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
