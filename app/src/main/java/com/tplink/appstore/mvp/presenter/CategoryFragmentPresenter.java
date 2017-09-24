package com.tplink.appstore.mvp.presenter;

import com.tplink.appstore.base.BaseActivity;
import com.tplink.appstore.base.mvpbase.BasePresenter;
import com.tplink.appstore.mvp.view.view.CategoryFragmentView;

/**
 * Created by wxmarr on 2017/9/17.
 */

public interface CategoryFragmentPresenter extends BasePresenter<CategoryFragmentView> {
    void getCategoryData(BaseActivity baseActivity);
}
