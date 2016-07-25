package com.example.maimenghuo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.maimenghuo.adapter.MainPagerAdapter;
import com.example.maimenghuo.framents.DiscoveyFragment;
import com.example.maimenghuo.framents.HomeFragment;
import com.example.maimenghuo.framents.PersonFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener
         {


    private ViewPager pager;
    private MainPagerAdapter adapter;
    private List<Fragment> data;
    private List<ImageView> image;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();



    }



    private void initView() {
        pager = (ViewPager) findViewById(R.id.main_viewPager);
        layout=(LinearLayout)findViewById(R.id.main_layout);
        int count=layout.getChildCount();
        image=new ArrayList<ImageView>();
        data=new ArrayList<>();
        HomeFragment homeFragment=new HomeFragment();
        data.add(homeFragment);
        DiscoveyFragment disFragment=new DiscoveyFragment();
        data.add(disFragment);
        PersonFragment personFragment=new PersonFragment();
        data.add(personFragment);


        adapter=new MainPagerAdapter(getSupportFragmentManager(),data);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(this);

        for (int i = 0; i <count ; i++) {
            final int j=i;
            ImageView iv= (ImageView) layout.getChildAt(i);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pager.setCurrentItem(j);
                }
            });
            image.add(iv);
        }


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < 3; i++) {
            image.get(i).setSelected(false);
            
        }
        image.get(position).setSelected(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

}



}
