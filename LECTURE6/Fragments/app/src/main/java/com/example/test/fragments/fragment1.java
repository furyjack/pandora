package com.example.test.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lakshay on 6/23/2016.
 */
public class fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_1, container, false);
        TextView tv=(TextView)view.findViewById(R.id.tv_name);
        tv.setTextColor(Color.GREEN);
        return  view;

    }
}
