package com.tplink.appstore.mvp.view.view;

import com.tplink.appstore.base.BaseFragment;
import com.tplink.appstore.base.mvpbase.BaseView;

/**
 * Created by wxmarr on 2017/9/3.
 */

public interface RecommendFragmentView extends BaseView {

    void onRecommendDataSuccess();
    void onRecommendDataFailed();
}
