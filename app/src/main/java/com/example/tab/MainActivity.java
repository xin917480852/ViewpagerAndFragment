package com.example.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        //viewpager＋FragmentPagerAdapter实现
        //viewpager可滑动
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }
    //点击事件
    private void initEvent()
    {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
    }
    //初始化数据
    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);
        //找到按钮 滑动的时候改变图片
        mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_img);
        mImgSettings = (ImageButton) findViewById(R.id.id_tab_settings_img);
        //实例化适配器
        mAdapter = new FragmentAndViewpagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        //活动的监听事件
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            public void onPageSelected(int arg0)
            {
                int currentItem = mViewPager.getCurrentItem();
                setTab(currentItem);
            }
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
                // TODO Auto-generated method stub

            }
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_settings:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    private void setSelect(int i)
    {
        setTab(i);
        // 切换内容区域
        mViewPager.setCurrentItem(i);
    }

    private void setTab(int i)
    {
        resetImgs();
        // 设置图片为亮色
        switch (i)
        {
            case 0:
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                mImgAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }

    //切换图片到暗色
    private void resetImgs()
    {
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgAddress.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);
    }

}
