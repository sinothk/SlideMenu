package com.sinothk.plugin.slideMenu.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.sinothk.plugin.slideMenu.SlideMenuAction;
import com.sinothk.plugin.slideMenu.SlideMenuLayout;
import com.sinothk.widget.bannerView.style1.BannerView;
import com.sinothk.widget.bannerView.style1.ext.BannerBean;
import com.sinothk.widget.bannerView.style1.ext.BannerUtil;

import java.util.ArrayList;
import java.util.List;

public class SideMenuDemoMain2Activity extends AppCompatActivity {

    SlideMenuLayout mainSlideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu_demo_main);

        ImmersionBar.with(this)
                .keyboardEnable(true)
                .init();

        mainSlideMenu = this.findViewById(R.id.mainSlideMenu);
        mainSlideMenu.setSlideMode(SlideMenuAction.SLIDE_MODE_LEFT);
        mainSlideMenu.setSlidePadding(120);
        mainSlideMenu.setContentToggle(true);
        mainSlideMenu.setAllowTogging(false);

        findViewById(R.id.main_btn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainSlideMenu.openLeftSlide();
            }
        });



        initbannerView();
    }

    private void initbannerView() {
        BannerView bannerView = this.findViewById(R.id.bannerView2);

        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int h = 508 * width / 1080;

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, h);
        bannerView.setLayoutParams(layoutParams);

        final List<BannerBean> bannerBeanList2 = new ArrayList<>();

        BannerBean banner2_1 = BannerBean.getEntity("T1", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2727129703,1839762678&fm=27&gp=0.jpg", "1");
        BannerBean banner2_2 = BannerBean.getEntity("T2", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2998709676,3706664345&fm=26&gp=0.jpg", "1");
        BannerBean banner2_3 = BannerBean.getEntity("T3", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2998709676,3706664345&fm=26&gp=0.jpg", "1");

        bannerBeanList2.add(banner2_3);
        bannerBeanList2.add(banner2_1);
        bannerBeanList2.add(banner2_2);

        BannerUtil.show(this, bannerView, bannerBeanList2, BannerUtil.RIGHT);
    }
}
