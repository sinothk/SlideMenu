package com.sinothk.plugin.coordinatormenudemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.plugin.coordinatormenu.CoordinatorMenu;
import com.sinothk.plugin.slideMenu.demo.R;


public class MainActivity extends AppCompatActivity {

    private ImageView mHeadIv;
    private CoordinatorMenu mCoordinatorMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity_main);

        mHeadIv = findViewById(R.id.iv_head);
        mCoordinatorMenu = findViewById(R.id.menu);

        mHeadIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCoordinatorMenu.isOpened()) {
                    mCoordinatorMenu.closeMenu();
                } else {
                    mCoordinatorMenu.openMenu();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mCoordinatorMenu.isOpened()) {
            mCoordinatorMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
