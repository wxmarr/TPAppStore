package com.tplink.appstore.mvp.view.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.tplink.appstore.R;
import com.tplink.appstore.adapter.FixPagerAdapter;
import com.tplink.appstore.base.BaseActivity;
import com.tplink.appstore.base.BaseFragment;
import com.tplink.appstore.factory.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wxmarr on 2017/7/19.
 */

public class HomeActivity extends BaseActivity{

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.main_viewpager)
    ViewPager mainViewPager;

    @BindView(R.id.status_bar)
    LinearLayout statusBar;

    private FixPagerAdapter fixPagerAdapter ;
    private String[] titles = {"推荐","分类","排行","管理","我的"};
    private List<Fragment> fragments ;


    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_home);
        mainViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
    }

    @Override
    protected void initView() {
        
        initViewPagerFragment();

    }

    private void initViewPagerFragment() {
        fixPagerAdapter = new FixPagerAdapter(getSupportFragmentManager());

        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            fragments.add(FragmentFactory.createFragment(i));
        }

        fixPagerAdapter.setTitles(titles);
        fixPagerAdapter.setFragments(fragments);

        mainViewPager.setAdapter(fixPagerAdapter);
        tabLayout.setupWithViewPager(mainViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        mainViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = FragmentFactory.createFragment(position);
                fragment.show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
