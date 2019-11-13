package com.demo.jetpack.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.demo.jetpack.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    private View mStatusBarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        overridePendingTransition(R.anim.common_slide_in_right,R.anim.common_slide_out_left);
        addStatusBar();
    }

    private void addStatusBar() {
        //条件状态栏透明，要不然不会起作用
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (mStatusBarView == null) {
            mStatusBarView = new View(BaseActivity.this);
            int screenWidth = getResources().getDisplayMetrics().widthPixels;
            int statusBarHeight = getStatusBarHeight();
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(screenWidth, statusBarHeight);
            mStatusBarView.setLayoutParams(params);
            mStatusBarView.requestLayout();
            //获取根布局
            ViewGroup systemContent = findViewById(android.R.id.content);
            ViewGroup userContent = (ViewGroup) systemContent.getChildAt(0);
            userContent.setFitsSystemWindows(false);
            userContent.addView(mStatusBarView, 0);
        }
    }

    public int getStatusBarHeight() {
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }

    public abstract int getLayout();
}
