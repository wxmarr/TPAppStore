package com.tplink.appstore.mvp.presenter.impl;

import android.os.SystemClock;

import com.tplink.appstore.base.BaseActivity;
import com.tplink.appstore.base.mvpbase.impl.BasePresentImpl;
import com.tplink.appstore.mvp.presenter.CategoryFragmentPresenter;
import com.tplink.appstore.mvp.view.view.CategoryFragmentView;

import javax.inject.Inject;

/**
 * Created by wxmarr on 2017/9/20.
 */

public class CategoryFragmentPresentImpl extends BasePresentImpl<CategoryFragmentView> implements CategoryFragmentPresenter {

    @Inject
    public CategoryFragmentPresentImpl() {

    }

    @Override
    public void getCategoryData(BaseActivity baseActivity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                mPresentenView.onCategoryDataSuccess();
            }
        }).start();
    }
}
