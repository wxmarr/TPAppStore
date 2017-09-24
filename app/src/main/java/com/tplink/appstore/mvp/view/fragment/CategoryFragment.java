package com.tplink.appstore.mvp.view.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tplink.appstore.R;
import com.tplink.appstore.base.BaseFragment;
import com.tplink.appstore.base.BaseMvpFragment;
import com.tplink.appstore.mvp.presenter.impl.CategoryFragmentPresentImpl;
import com.tplink.appstore.mvp.view.view.CategoryFragmentView;
import com.tplink.appstore.utils.UIUtils;
import com.tplink.appstore.view.LoadingPager;

import javax.inject.Inject;

/**
 * Created by wxmarr on 2017/8/21.
 */

public class CategoryFragment extends BaseMvpFragment<CategoryFragmentPresentImpl> implements CategoryFragmentView{

    @Inject
    public CategoryFragmentPresentImpl categoryFragmentPresent;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View createSuccessView() {
//        View view = UIUtils.inflate(R.layout.fragment_category);
//        return view;
        TextView tv = new TextView(getContext());
        tv.setText("loading success");
        return tv;
    }

    @Override
    public void load() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(2000);
//                setState(LoadingPager.LoadResult.success);
//            }
//        }).start();
        categoryFragmentPresent.getCategoryData(mActivity);
    }


    @Override
    protected CategoryFragmentPresentImpl initInjector() {
        mFragmentComponent.inject(this);
        return categoryFragmentPresent;
    }

    @Override
    public void shotToast(String msg) {

    }

    @Override
    public void onCategoryDataSuccess() {
        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onCategoryDataError(String msg) {
        setState(LoadingPager.LoadResult.error);
    }
}
