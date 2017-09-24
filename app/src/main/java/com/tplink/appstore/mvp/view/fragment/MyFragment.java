package com.tplink.appstore.mvp.view.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tplink.appstore.R;
import com.tplink.appstore.base.BaseFragment;
import com.tplink.appstore.utils.UIUtils;
import com.tplink.appstore.view.LoadingPager;

/**
 * Created by wxmarr on 2017/8/21.
 */

public class MyFragment extends BaseFragment {



    @Override
    public View createSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_my);
        return view;
    }

    @Override
    public void load() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                setState(LoadingPager.LoadResult.error);
            }
        }).start();
    }

    @Override
    public void shotToast(String msg) {

    }
}
