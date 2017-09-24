package com.tplink.appstore.base.mvpbase.impl;

import com.tplink.appstore.base.mvpbase.BasePresenter;
import com.tplink.appstore.base.mvpbase.BaseView;

/**
 * Created by wxmarr on 2017/9/3.
 */

public class BasePresentImpl<T extends BaseView> implements BasePresenter<T> {

    protected T mPresentenView;

    @Override
    public void attachView(T view) {
        mPresentenView = view;
    }

    @Override
    public void detachView() {
        mPresentenView = null;
    }
}
