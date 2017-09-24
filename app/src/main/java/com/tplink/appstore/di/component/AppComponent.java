package com.tplink.appstore.di.component;

import android.content.Context;

import com.tplink.appstore.di.module.AppModule;
import com.tplink.appstore.di.scope.ContextLife;
import com.tplink.appstore.di.scope.PerApp;

import dagger.Component;

/**
 * Created by wxmarr on 2017/9/2.
 *
 * 提供全局单例的Context对象
 *
 */

@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    Context getApplicationContext();
}

