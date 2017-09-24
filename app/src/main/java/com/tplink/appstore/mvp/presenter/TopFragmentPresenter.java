package com.tplink.appstore.mvp.presenter;

import com.tplink.appstore.base.BaseActivity;
import com.tplink.appstore.base.mvpbase.BasePresenter;
import com.tplink.appstore.mvp.view.view.TopFragmentView;

/**
 * Created by wxmarr on 2017/9/20.
 */

public interface TopFragmentPresenter extends BasePresenter<TopFragmentView> {
    void getTopData(BaseActivity activity);
}
