package com.demo.jetpack.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.demo.jetpack.R;
import com.demo.jetpack.base.BaseActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends BaseActivity {
    private long lastTime = 0;
    private static final String TAG = "MainActivity";
    private BottomNavigationViewEx mBottomNav;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String toMain = intent.getStringExtra("toMain");
        Toast.makeText(this,toMain,Toast.LENGTH_SHORT).show();

        initBottomTab();
    }

    private void initBottomTab() {
        NavController navController = Navigation.findNavController(this, R.id.my_nav_host_fragment);
        mBottomNav = findViewById(R.id.bnv_bottom_nav);
        mBottomNav.enableAnimation(false);
        NavigationUI.setupWithNavController(mBottomNav, navController);

        //设置气泡位置和数目
        addBadgeAt(2,99);

    }

    private Badge addBadgeAt(int position, int number) {
        // add badge
        return new QBadgeView(this)
                .setBadgeNumber(number)
                .setGravityOffset(36, 2, true)
                .bindTarget(mBottomNav.getBottomNavigationItemView(position))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState)
                            Toast.makeText(MainActivity.this, "Ddd", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime > 1500) {
            lastTime = System.currentTimeMillis();
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
        } else
            super.onBackPressed();
    }

}
