package com.tplink.appstore.mvp.presenter.impl;

import android.os.SystemClock;
import android.util.Log;

import com.tplink.appstore.base.BaseActivity;
import com.tplink.appstore.base.mvpbase.impl.BasePresentImpl;
import com.tplink.appstore.mvp.presenter.RecommendFragmentPresenter;
import com.tplink.appstore.mvp.view.view.RecommendFragmentView;

import javax.inject.Inject;

/**
 * Created by wxmarr on 2017/9/3.
 */

public class RecommendPresentImpl extends BasePresentImpl<RecommendFragmentView> implements RecommendFragmentPresenter {

    @Inject
    public RecommendPresentImpl(){

    }

    @Override
    public void getRecommendData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
//                mPresentenView.onRecommendDataSuccess();
                mPresentenView.onRecommendDataFailed();
            }
        }).start();
    }

    @Override
    public void getRecommendDataMore() {

    }
}
