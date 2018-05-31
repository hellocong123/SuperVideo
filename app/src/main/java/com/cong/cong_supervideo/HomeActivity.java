package com.cong.cong_supervideo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Cong
 * @date 2018/5/31
 * @description
 */
public class HomeActivity extends BaseActivity {


    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);


        setSupportActionBar();
        setActionBarIcon(R.mipmap.ic_drawer_home);
        //这是Activity里的setTitle，如果想设置Toolbar里的方法的话，要把setTitle()放在setSupportActionBar前面
        setTitle("首页");
        //  mToolBar.setTitle("首页");
        // getSupportActionBar().setTitle("首页");


        //设置可以使用Toolbar左按钮控制侧滑菜单的开关
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.drawer_open, R.string.drawer_close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }
}
