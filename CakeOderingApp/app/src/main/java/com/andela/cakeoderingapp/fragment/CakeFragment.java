package com.andela.cakeoderingapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andela.cakeoderingapp.R;

/**
 * Created by andeladev on 28/01/2016.
 */
public class CakeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cake_fragment, container, false);
        return view;
    }
}
