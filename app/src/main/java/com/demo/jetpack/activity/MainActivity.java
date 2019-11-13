package com.demo.jetpack.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.demo.jetpack.R;
import com.demo.jetpack.base.BaseActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends BaseActivity {
    private long lastTime = 0;
    private static final String TAG = "MainActivity";
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime > 1500) {
            lastTime = System.currentTimeMillis();
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
        } else
            super.onBackPressed();
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
        BottomNavigationViewEx bottomNav = findViewById(R.id.bnv_bottom_nav);
        bottomNav.enableAnimation(false);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }
}
