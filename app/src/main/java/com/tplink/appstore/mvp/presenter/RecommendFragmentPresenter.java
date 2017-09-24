package com.tplink.appstore.mvp.presenter;

import com.tplink.appstore.base.BaseActivity;
import com.tplink.appstore.base.mvpbase.BasePresenter;
import com.tplink.appstore.mvp.view.view.RecommendFragmentView;

/**
 * Created by wxmarr on 2017/9/3.
 */

public interface RecommendFragmentPresenter extends BasePresenter<RecommendFragmentView> {
    void getRecommendData();
    void getRecommendDataMore();
}
