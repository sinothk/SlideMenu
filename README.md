# 引入
## Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:
        
        allprojects {
          repositories {
            ...
            maven { url 'https://www.jitpack.io' }
          }
        }

## Step 2. Add the dependency

        dependencies {
                implementation 'com.github.sinothk:SlideMenu:2.x.1015'
        }

# 使用
  ## xml
   主页：
   
    <?xml version="1.0" encoding="utf-8"?>
    <com.sinothk.plugin.slideMenu.SlideMenuLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      android:id="@+id/mainSlideMenu"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:background="@color/white"
      app:slideMode="both">
      <include layout="@layout/activity_side_menu_demo_main_left" />
      <include layout="@layout/activity_side_menu_demo_main_r" />
      <include layout="@layout/content_menu_content" />
    </com.sinothk.plugin.slideMenu.SlideMenuLayout>
    
    菜单：left_menu
    
    内容：right_content
    
   ## java
   
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
    //         .navigationBarColor(R.color.colorPrimary)
                .init();

        mMainSwipemenu = findViewById(R.id.main_swipemenu);
        mainSlideMenu = this.findViewById(R.id.mainSlideMenu);
        mainSlideMenu.setSlideMode(SlideMenuAction.SLIDE_MODE_LEFT);
        mainSlideMenu.setSlidePadding(120);
        mainSlideMenu.setContentToggle(true);
        mainSlideMenu.setAllowTogging(false);
    }
    
