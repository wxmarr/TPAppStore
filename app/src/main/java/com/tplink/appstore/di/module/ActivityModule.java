package com.tplink.appstore.di.module;

import android.app.Activity;
import android.content.Context;

import com.tplink.appstore.di.scope.ContextLife;
import com.tplink.appstore.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wxmarr on 2017/8/27.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    public Activity providerActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context providerActivityContext() {
        return mActivity;
    }
}
