package com.example.maimenghuo.framents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.maimenghuo.R;
import com.example.maimenghuo.adapter.DiscoveryPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveyFragment extends Fragment {


    private View view;
    private LinearLayout searchLayout;//搜索
    private RelativeLayout tabDiscovery;
    private ImageView discoveryIV;
    private View discoveryView;
    private RelativeLayout tabGoods;
    private ImageView goodsIV;
    private View goodsView;
    private ViewPager viewPager;

    public DiscoveyFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bdiscoveylank, container, false);
        initView();//初始化view
        initListener();//初始化各种监听事件
        return view;
    }



    private void initView() {
        //搜索
        searchLayout = (LinearLayout)view.findViewById(R.id.search_layout);
        //导航攻略模块
        tabDiscovery = (RelativeLayout) view.findViewById(R.id.tab_discovery);
        discoveryIV = (ImageView) view.findViewById(R.id.discovery_iv);
        discoveryView = (View) view.findViewById(R.id.discovery_view);
        //导航商品模块
        tabGoods = (RelativeLayout) view.findViewById(R.id.tab_goods);
        goodsIV = (ImageView) view.findViewById(R.id.goods_iv);
        goodsIV.setVisibility(View.INVISIBLE);
        goodsView = (View) view.findViewById(R.id.goods_view);
        goodsView.setVisibility(View.INVISIBLE);

        //初始化viewpager
        viewPager = (ViewPager) view.findViewById(R.id.discovery_viewPager);
        List<Fragment> fragments=new ArrayList<>();
        DiscoveryItemFragment itemFragment=new DiscoveryItemFragment();
        DiscoveryGoodsFragment goodsFragment=new DiscoveryGoodsFragment();
        fragments.add(itemFragment);
        fragments.add(goodsFragment);
        DiscoveryPagerAdapter pagerAdapter=new DiscoveryPagerAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPager.setAdapter(pagerAdapter);

    }
    private void initListener() {
        //搜索点击事件
        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //导航点击事件
        tabDiscovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tabGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        //viewPager的监听事件
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    discoveryIV.setVisibility(View.VISIBLE);
                    discoveryView.setVisibility(View.VISIBLE);
                    goodsIV.setVisibility(View.INVISIBLE);
                    goodsView.setVisibility(View.INVISIBLE);
                }else{
                    discoveryIV.setVisibility(View.INVISIBLE);
                    discoveryView.setVisibility(View.INVISIBLE);
                    goodsIV.setVisibility(View.VISIBLE);
                    goodsView.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }
}
