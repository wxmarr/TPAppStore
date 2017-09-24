package com.tplink.appstore.mvp.presenter.impl;

import android.os.SystemClock;

import com.tplink.appstore.base.BaseActivity;
import com.tplink.appstore.base.mvpbase.impl.BasePresentImpl;
import com.tplink.appstore.mvp.presenter.TopFragmentPresenter;
import com.tplink.appstore.mvp.view.view.TopFragmentView;

import javax.inject.Inject;

/**
 * Created by wxmarr on 2017/9/20.
 */

public class TopFragmentPresentImpl extends BasePresentImpl<TopFragmentView> implements TopFragmentPresenter {

    @Inject
    public TopFragmentPresentImpl() {
    }

    @Override
    public void getTopData(BaseActivity activity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                mPresentenView.onTopDataSuccess();
            }
        }).start();
    }
}
