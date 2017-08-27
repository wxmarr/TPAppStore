package com.tplink.appstore.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tplink.appstore.R;
import com.tplink.appstore.base.BaseFragment;
import com.tplink.appstore.utils.UIUtils;
import com.tplink.appstore.view.LoadingPager;

/**
 * Created by wxmarr on 2017/8/16.
 */

public class RecommendFragment extends BaseFragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    public void shotToast(String msg) {

    }

    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(getContext());
        tv.setText("loading success");
        return tv;
    }

    @Override
    protected void load() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                setState(LoadingPager.LoadResult.error);
            }
        }).start();
    }
}
