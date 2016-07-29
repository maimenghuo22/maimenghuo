package com.example.maimenghuo.framents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maimenghuo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {


    public PersonFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_person, container, false);
        return view;
    }

}
