package com.example.maimenghuo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class DiscoveryPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;

    public DiscoveryPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data==null?0:data.size();
    }
}
