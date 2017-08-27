package com.tplink.appstore.di.module;

import android.content.Context;

import com.tplink.appstore.base.StoreApplication;
import com.tplink.appstore.di.scope.ContextLife;
import com.tplink.appstore.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wxmarr on 2017/8/27.
 */

@Module
public class AppModule {

    private StoreApplication storeApplication;

    public AppModule(StoreApplication application) {
        this.storeApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context providerAppContext() {
        return storeApplication.getApplicationContext();
    }
}
