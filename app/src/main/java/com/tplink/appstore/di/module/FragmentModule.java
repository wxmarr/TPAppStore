package com.tplink.appstore.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.tplink.appstore.di.scope.ContextLife;
import com.tplink.appstore.di.scope.PerActivity;
import com.tplink.appstore.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wxmarr on 2017/8/27.
 */

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    public Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @PerFragment
    public Activity provideFragmentActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideFragmentContext() {
        return mFragment.getContext();
    }
}
