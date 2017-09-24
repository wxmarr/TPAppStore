package com.tplink.appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.tplink.appstore.di.module.FragmentModule;
import com.tplink.appstore.di.scope.ContextLife;
import com.tplink.appstore.di.scope.PerFragment;
import com.tplink.appstore.mvp.view.fragment.CategoryFragment;
import com.tplink.appstore.mvp.view.fragment.RecommendFragment;
import com.tplink.appstore.mvp.view.fragment.TopFragment;

import dagger.Component;

/**
 * Created by wxmarr on 2017/9/2.
 */

@PerFragment
@Component(modules = FragmentModule.class , dependencies = AppComponent.class)
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(RecommendFragment fragment);
    void inject(CategoryFragment fragment);
    void inject(TopFragment fragment);
}
