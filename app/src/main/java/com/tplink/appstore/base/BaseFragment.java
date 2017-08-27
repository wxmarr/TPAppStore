package com.tplink.appstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tplink.appstore.mvp.view.BaseView;
import com.tplink.appstore.view.LoadingPager;

/**
 * Created by wxmarr on 2017/8/16.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    private LoadingPager loadingPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (loadingPager == null) {
            loadingPager = new LoadingPager(getContext()) {
                @Override
                protected void load() {
                    BaseFragment.this.load();
                }

                @Override
                protected View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }
            };
        }
        return loadingPager;
    }

    public void show() {
        if (loadingPager != null) {
            loadingPager.show();
        }
    }

    public void setState(LoadingPager.LoadResult loadResult) {
        if (loadingPager != null) {
            loadingPager.setState(loadResult);
        }
    }


    protected abstract View createSuccessView();
    protected abstract void load();
}
