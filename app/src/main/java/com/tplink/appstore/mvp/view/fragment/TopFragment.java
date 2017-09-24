package com.tplink.appstore.mvp.view.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tplink.appstore.R;
import com.tplink.appstore.base.BaseFragment;
import com.tplink.appstore.base.BaseMvpFragment;
import com.tplink.appstore.mvp.presenter.impl.TopFragmentPresentImpl;
import com.tplink.appstore.mvp.view.view.TopFragmentView;
import com.tplink.appstore.utils.UIUtils;
import com.tplink.appstore.view.LoadingPager;

import javax.inject.Inject;

/**
 * Created by wxmarr on 2017/8/21.
 */

public class TopFragment extends BaseMvpFragment<TopFragmentPresentImpl> implements  TopFragmentView {


    @Inject
    public TopFragmentPresentImpl topFragmentPresent;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View createSuccessView() {
//        View view = UIUtils.inflate(R.layout.fragment_top);
//        return view;
        TextView tv = new TextView(getContext());
        tv.setText("loading success");
        return tv;
    }

    @Override
    public void load() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(2000);
//                setState(LoadingPager.LoadResult.empty);
//            }
//        }).start();
        topFragmentPresent.getTopData(mActivity);
    }

    @Override
    protected TopFragmentPresentImpl initInjector() {
        mFragmentComponent.inject(this);
        return topFragmentPresent;
    }

    @Override
    public void shotToast(String msg) {

    }

    @Override
    public void onTopDataSuccess() {
        setState(LoadingPager.LoadResult.success);

    }

    @Override
    public void onTopDataError() {
        setState(LoadingPager.LoadResult.error);

    }
}
