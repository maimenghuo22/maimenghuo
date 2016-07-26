package com.example.maimenghuo.framents;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maimenghuo.R;

/**
 *
 */
public class DiscoveryGoodsFragment extends Fragment {

    public DiscoveryGoodsFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discovery_goods, container, false);
    }
}
