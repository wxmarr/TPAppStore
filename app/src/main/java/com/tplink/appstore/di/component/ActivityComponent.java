package com.tplink.appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.tplink.appstore.mvp.view.activity.HomeActivity;
import com.tplink.appstore.di.module.ActivityModule;
import com.tplink.appstore.di.scope.ContextLife;
import com.tplink.appstore.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by wxmarr on 2017/9/2.
 */

@PerActivity
@Component(modules = ActivityModule.class , dependencies = AppComponent.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(HomeActivity activity);
}
