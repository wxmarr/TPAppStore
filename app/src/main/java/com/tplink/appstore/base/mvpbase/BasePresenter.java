package com.tplink.appstore.base.mvpbase;

/**
 * Created by wxmarr on 2017/9/3.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);
    void detachView();
}
