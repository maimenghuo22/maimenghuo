package com.example.maimenghuo.framents;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.maimenghuo.R;
import com.example.maimenghuo.Utils.UriUtil;
import com.example.maimenghuo.adapter.HeadPagerAdapter;
import com.example.maimenghuo.bean.Banner;
import com.google.gson.Gson;

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
    private View mView,headView;
    private List<Banner.DataBean.BannersBean> data;
    private ListView lv;
    private ViewPager pager;
    private HeadPagerAdapter mAdapter;
    private List<ImageView> point;
    private LinearLayout mlayout;
    private ScrollingView scollview;
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
       // scollview=headView.findViewById(R.id.scollview)
        lv.addHeaderView(headView);


        initView();
        initData();
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
                        pager.setCurrentItem(i++%5);
                    }
                });

            }
        },0,3000);

        return mView;
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

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            data=banner.getData().getBanners();

                                mAdapter.setData(data);






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

        for (int i = 0; i <mlayout.getChildCount() ; i++) {
            ImageView iv= (ImageView) mlayout.getChildAt(i);
            point.add(iv);


        }
        point.get(0).setSelected(true);




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


}
