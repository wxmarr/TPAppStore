package com.tplink.appstore.mvp.view.view;

import com.tplink.appstore.base.mvpbase.BaseView;
import com.tplink.appstore.bean.CategoryBean;

/**
 * Created by wxmarr on 2017/9/17.
 */

public interface CategoryFragmentView extends BaseView {
    void onCategoryDataSuccess();
    void onCategoryDataError(String msg);
}
