package com.youdeyi.nurse.view.activity.common;

import android.content.Intent;

import com.youdeyi.nurse.R;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class BaseActivity extends SwipeBackActivity {

    //Activity切换实现淡入淡出效果
    protected void startActivityByFade(Intent intent){
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    //实现由左向右滑入效果
    protected void startActivityBySlide(Intent intent){
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
    //实现由放大缩小效果
    protected void startActivityByZoom(Intent intent){
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
    }

}
