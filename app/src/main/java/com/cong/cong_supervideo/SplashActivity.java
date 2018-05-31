package com.cong.cong_supervideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private boolean isFirstIn;

    private final int GO_GUIDE = 1;
    private final int GO_HOME = 2;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case GO_GUIDE:
                    startGuideActivity();
                    break;

                case GO_HOME:
                    startHomeActivity();
                    break;
            }

        }
    };

    private void startHomeActivity() {

        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }

    private void startGuideActivity() {

        Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
        startActivity(intent);
        finish();

    }

    private SharedPreferences mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        mSp = getSharedPreferences("config", MODE_PRIVATE);
        init();
    }

    private void init() {

        boolean isFirstIn = mSp.getBoolean("IsFirstIn", true);

        if (isFirstIn) {

            mHandler.sendEmptyMessageDelayed(GO_GUIDE, 1000);

            mSp.edit().putBoolean("IsFirstIn",false).commit();
        } else {
            mHandler.sendEmptyMessageDelayed(GO_HOME, 1000);

        }
    }
}
