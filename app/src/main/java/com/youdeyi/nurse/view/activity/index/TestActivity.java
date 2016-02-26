package com.youdeyi.nurse.view.activity.index;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.youdeyi.nurse.R;
import com.youdeyi.nurse.view.activity.common.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {

    @Bind(R.id.click)
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.click)
    public void onClick() {
        startActivity(new Intent(this,Test2Activity.class));
    }
}
