package com.youdeyi.nurse.view.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youdeyi.nurse.R;
import com.youdeyi.nurse.view.activity.common.BaseActivity;
import com.youdeyi.nurse.view.fragment.FindFragment;
import com.youdeyi.nurse.view.fragment.IndexFragment;
import com.youdeyi.nurse.view.fragment.MeFragment;
import com.youdeyi.nurse.view.fragment.RemindFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Bind(R.id.index_image)
    ImageView indexImage;
    @Bind(R.id.index_text)
    TextView indexText;
    @Bind(R.id.index_layout)
    RelativeLayout indexLayout;
    @Bind(R.id.find_image)
    ImageView findImage;
    @Bind(R.id.find_text)
    TextView findText;
    @Bind(R.id.find_layout)
    RelativeLayout findLayout;
    @Bind(R.id.remind_image)
    ImageView remindImage;
    @Bind(R.id.remind_text)
    TextView remindText;
    @Bind(R.id.remind_layout)
    RelativeLayout remindLayout;
    @Bind(R.id.me_image)
    ImageView meImage;
    @Bind(R.id.me_text)
    TextView meText;
    @Bind(R.id.me_layout)
    RelativeLayout meLayout;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    private IndexFragment indexFragment;
    private FindFragment findFragment;
    private RemindFragment remindFragment;
    private MeFragment meFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = getFragmentManager();

        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }


    @OnClick({R.id.index_layout, R.id.find_layout, R.id.remind_layout, R.id.me_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.index_layout:
                setTabSelection(0);
                break;
            case R.id.find_layout:
                setTabSelection(1);
                break;
            case R.id.remind_layout:
                setTabSelection(2);
                break;
            case R.id.me_layout:
                setTabSelection(3);
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了首页tab时，改变控件的图片和文字颜色
                indexImage.setImageResource(R.mipmap.tab_index_hover);
                indexText.setTextColor(getResources().getColor(R.color.common_green));
                if (indexFragment == null) {
                    // 如果indexFragment为空，则创建一个并添加到界面上
                    indexFragment = new IndexFragment();
                    transaction.add(R.id.content, indexFragment);
                } else {
                    // 如果indexFragment不为空，则直接将它显示出来
                    transaction.show(indexFragment);
                }
                break;
            case 1:
                // 当点击了发现tab时，改变控件的图片和文字颜色
                findImage.setImageResource(R.mipmap.tab_find_hover);
                findText.setTextColor(getResources().getColor(R.color.common_green));
                if (findFragment == null) {
                    // 如果findFragment为空，则创建一个并添加到界面上
                    findFragment = new FindFragment();
                    transaction.add(R.id.content, findFragment);
                } else {
                    // 如果findFragment不为空，则直接将它显示出来
                    transaction.show(findFragment);
                }
                break;
            case 2:
                // 当点击了提醒tab时，改变控件的图片和文字颜色
                remindImage.setImageResource(R.mipmap.tab_remind_hover);
                remindText.setTextColor(getResources().getColor(R.color.common_green));
                if (remindFragment == null) {
                    // 如果remindFragment为空，则创建一个并添加到界面上
                    remindFragment = new RemindFragment();
                    transaction.add(R.id.content, remindFragment);
                } else {
                    // 如果remindFragment不为空，则直接将它显示出来
                    transaction.show(remindFragment);
                }
                break;
            case 3:
            default:
                // 当点击了我tab时，改变控件的图片和文字颜色
                meImage.setImageResource(R.mipmap.tab_me_hover);
                meText.setTextColor(getResources().getColor(R.color.common_green));
                if (meFragment == null) {
                    // 如果meFragment为空，则创建一个并添加到界面上
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    // 如果meFragment不为空，则直接将它显示出来
                    transaction.show(meFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        indexImage.setImageResource(R.mipmap.tab_index_norm);
        indexText.setTextColor(getResources().getColor(R.color.common_darker_gray));
        findImage.setImageResource(R.mipmap.tab_find_norm);
        findText.setTextColor(getResources().getColor(R.color.common_darker_gray));
        remindImage.setImageResource(R.mipmap.tab_remind_norm);
        remindText.setTextColor(getResources().getColor(R.color.common_darker_gray));
        meImage.setImageResource(R.mipmap.tab_me_norm);
        meText.setTextColor(getResources().getColor(R.color.common_darker_gray));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (indexFragment != null) {
            transaction.hide(indexFragment);
        }
        if (findFragment != null) {
            transaction.hide(findFragment);
        }
        if (remindFragment != null) {
            transaction.hide(remindFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }
}
