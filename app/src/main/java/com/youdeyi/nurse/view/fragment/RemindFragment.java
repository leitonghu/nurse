package com.youdeyi.nurse.view.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youdeyi.nurse.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemindFragment extends Fragment {


    public RemindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_remind, container, false);
    }


}
