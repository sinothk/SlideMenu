package com.sinothk.plugin.slideMenu.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.sinothk.plugin.slideMenu.view.SwipeMenu;


public class SlideMenuDemo1MainActivity extends AppCompatActivity implements View.OnClickListener {

    SwipeMenu mMainSwipemenu;
    ImageButton mBtnMenu;
    Button menuCloseBtn;
    @Override
    public void onBackPressed() {
        if (mMainSwipemenu.isMenuShowing()) {
            mMainSwipemenu.hideMenu();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_menu:
                if (mMainSwipemenu.isMenuShowing()) {
                    mMainSwipemenu.hideMenu();
                } else {
                    mMainSwipemenu.showMenu();
                }
                break;
            case R.id.menuCloseBtn:
                mMainSwipemenu.hideMenu();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_menu_activity_main);

        ImmersionBar.with(this)
                .keyboardEnable(true)
//                .navigationBarColor(R.color.colorPrimary)
                .init();

        mMainSwipemenu = findViewById(R.id.main_swipemenu);
        menuCloseBtn = findViewById(R.id.menuCloseBtn);

        mBtnMenu = findViewById(R.id.main_btn_menu);

        mBtnMenu.setOnClickListener(this);
        menuCloseBtn.setOnClickListener(this);

        mMainSwipemenu.setMenuOffset(0);

        mMainSwipemenu.setBackgroundResource(R.color.red);
    }
}
