package com.example.maimenghuo.framents;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.maimenghuo.NewsActivity;
import com.example.maimenghuo.NewsItemActivity;
import com.example.maimenghuo.R;
import com.example.maimenghuo.ToolActivity;
import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.HeadPagerAdapter;
import com.example.maimenghuo.adapter.MainAdapter;
import com.example.maimenghuo.bean.Banner;
import com.example.maimenghuo.bean.Banners;
import com.example.maimenghuo.bean.Posts;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private View mView,headView;
    private MainAdapter adpter;
    private List<Posts.DataBean.PostsBean> pdps;
    private List<Banner.DataBean.BannersBean> data;
    private List<Banners.DataBean.SecondaryBannersBean> list;
    private ListView lv;
    private ViewPager pager;


    private HeadPagerAdapter mAdapter;
    private List<ImageView> point;
    private LinearLayout mlayout;
    private HorizontalScrollView scollview;
    private Handler handler=new Handler();



    public HomeFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_home,container,false);

        lv = (ListView)mView.findViewById(R.id.home_listView);
        headView=inflater.inflate(R.layout.headlayout,lv,false);
        scollview= (HorizontalScrollView) headView.findViewById(R.id.scollview);

        lv.addHeaderView(headView);

        initView();

        adpter=new MainAdapter(getActivity(),pdps);
        lv.setAdapter(adpter);
       // lv.setOnItemClickListener(this);



        initImageData();
        initMainData();



        mAdapter=new HeadPagerAdapter(getActivity());

        pager.setAdapter(mAdapter);

        pager.setOnPageChangeListener(this);

        Timer timer=new Timer( true);
        timer.schedule(new TimerTask() {
            int i=0;
            @Override
            public void run() {
                pager.post(new Runnable() {
                    @Override
                    public void run() {
                        pager.setCurrentItem(i++%4);
                    }
                });

            }
        },0,3000);

        return mView;
    }

    private void initMainData() {
        OkHttpClient okHt=new OkHttpClient();
        Request request=new Request.Builder().url(UriUtil.homeURi).build();
        Call call=okHt.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
              String str2=response.body().string();
                if (str2 != null) {
                    Gson gson=new Gson();
                    final Posts posts = gson.fromJson(str2, Posts.class);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            pdps.addAll(posts.getData().getPosts());
                            adpter.notifyDataSetChanged();

                        }
                    });
                }
            }
        });
    }

    private void initImageData() {
        OkHttpClient okHttp=new OkHttpClient();
        Request ret=new Request.Builder().url(UriUtil.goodURi).build();
        Call call1=okHttp.newCall(ret);
        call1.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str1=response.body().string();
                if (str1 != null) {
                    Gson gson=new Gson();
                    final Banners banners=gson.fromJson(str1,Banners.class);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            list=banners.getData().getSecondary_banners();
                            LinearLayout layout=new LinearLayout(getActivity());
                            for (int i = 0; i <list.size() ; i++) {
                                ImageView iv=new ImageView(getActivity());
                                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                String path=list.get(i).getImage_url();
                                Picasso.with(getActivity()).load(path).error(R.mipmap.ic_launcher)
                                        .placeholder(R.mipmap.ic_launcher).centerCrop().config(Bitmap.Config.RGB_565)
                                        .resize(100,100).into(iv);
                         // int index=i;
                               layout.addView(iv);
//                                layout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//
//                                      Intent intent=new Intent(getActivity(), NewsItemActivity.class);
//                                        intent.putExtra("index",index);
//                                        startActivity(intent);
//;                                    }
//                                });

                            }

                            scollview.addView(layout);

                        }
                    });
                }


            }
        });

    }

    private void initData() {
        OkHttpClient okhttp=new OkHttpClient();
        Request request=new Request.Builder().url(UriUtil.headUri).build();
        Call call=okhttp.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            String str=response.body().string();
                if (str != null) {

                    Gson gson=new Gson();
                    final Banner banner=gson.fromJson(str,Banner.class);

                    Log.d(TAG, "onResponse: "+banner);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            data=banner.getData().getBanners();

                                mAdapter.setData(data);
                            point.get(0).setSelected(true);






                        }
                    });

                }
            }
        });
    }

    private void initView() {
        pager = (ViewPager) headView.findViewById(R.id.headViewpager);


        mlayout = (LinearLayout) headView.findViewById(R.id.point_layout);

        point=new ArrayList<>();
        data=new ArrayList<>();
        list=new ArrayList<>();

        for (int i = 0; i <mlayout.getChildCount() ; i++) {
            ImageView iv= (ImageView) mlayout.getChildAt(i);

            point.add(iv);


        }
        initData();


        pdps=new ArrayList<>();




    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i <4 ; i++) {
            point.get(i).setSelected(false);

        }
        point.get(position).setSelected(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//    String url=pdps.get(position).getPost_items().get(position).getUrl();
//        String toolUrl=pdps.get(position).getContent_url();
//
//        Intent intent=new Intent(getActivity(), NewsActivity.class);
//
//        intent.putExtra("url",url);
//        startActivity(intent);
//        Intent intent11=new Intent(getActivity(), ToolActivity.class);
//        intent11.putExtra("toolUrl",toolUrl);
//        startActivity(intent11);
//
//
//    }
}
