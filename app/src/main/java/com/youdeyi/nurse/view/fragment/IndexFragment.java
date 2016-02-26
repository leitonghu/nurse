package com.youdeyi.nurse.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.youdeyi.nurse.R;
import com.youdeyi.nurse.view.activity.index.TestActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IndexFragment extends Fragment {
    @Bind(R.id.id_click)
    Button idClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.id_click)
    public void onClick() {
        startActivity(new Intent(getActivity(),TestActivity.class));
    }
}
