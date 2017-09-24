package com.tplink.appstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.tplink.appstore.base.mvpbase.BasePresenter;
import com.tplink.appstore.base.mvpbase.BaseView;
import com.tplink.appstore.di.component.ActivityComponent;
import com.tplink.appstore.di.component.DaggerActivityComponent;
import com.tplink.appstore.di.module.ActivityModule;

/**
 * Created by wxmarr on 2017/9/3.
 *
 * Activity实现MVP的基类
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {


    protected ActivityComponent acticityComponent;

    protected T mPresenter;

    //通过Dagger2注入的是presenter

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initActivityComponent();
        mPresenter = initInjector();

        mPresenter.attachView(this);
    }

    public void initActivityComponent() {
        acticityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((StoreApplication)getApplication()).getAppComponent())
                .build();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void shotToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 完成注入并返回presentor对象
     * @return
     */
    protected abstract T initInjector();

}
