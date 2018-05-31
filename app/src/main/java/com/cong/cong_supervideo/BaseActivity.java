package com.cong.cong_supervideo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * @author Cong
 * @date 2018/5/31
 * @description 设置和ActionBar相关的一些东西放在基类里面
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        initView();

        initData();
    }

    protected void setSupportActionBar() {

        mToolBar = bindViewId(R.id.toolbar);
        if (mToolBar != null) {

            setSupportActionBar(mToolBar);
        }
    }

    //设置toolbar的左图标
    protected void setActionBarIcon(int resId) {
        if (mToolBar != null) {
            mToolBar.setNavigationIcon(resId);
        }
    }

    //比如：当是一个TextView的时候，它继承View，返回也是一个TextView

    protected <T extends View> T bindViewId(int resId) {
        return findViewById(resId);
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();
}
