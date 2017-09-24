package com.tplink.appstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.tplink.appstore.base.BaseFragment;
import com.tplink.appstore.base.mvpbase.BasePresenter;
import com.tplink.appstore.base.mvpbase.BaseView;
import com.tplink.appstore.di.component.DaggerFragmentComponent;
import com.tplink.appstore.di.component.FragmentComponent;
import com.tplink.appstore.di.module.FragmentModule;

/**
 * Created by wxmarr on 2017/9/3.
 * 将Dragger2依赖注入和绑定view的操作提取出来
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected FragmentComponent mFragmentComponent;
    protected T mPresenter ;

    protected void  initFragmentComponent(){
        mFragmentComponent = DaggerFragmentComponent.builder()
                .fragmentModule(new FragmentModule(this))
                .appComponent(((StoreApplication)(getActivity().getApplication())).getAppComponent())
                .build();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFragmentComponent();
        mPresenter = initInjector();
        mPresenter.attachView(this);
    }

    protected abstract T  initInjector();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    public void shotToast(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

}
