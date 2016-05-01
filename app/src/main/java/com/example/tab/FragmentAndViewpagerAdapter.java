package com.example.tab;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小新 on 2016/4/30.
 * 设配器
 */
public class FragmentAndViewpagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    public FragmentAndViewpagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<Fragment>();
        Fragment mTab01 = new WeixinFragment();
        Fragment mTab02 = new FrdFragment();
        Fragment mTab03 = new AddressFragment();
        Fragment mTab04 = new SettingsFragment();
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
