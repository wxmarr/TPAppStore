package com.tplink.appstore.base;

import android.os.Handler;
import android.util.Log;

import com.tplink.appstore.BuildConfig;
import com.tplink.appstore.di.component.AppComponent;
import com.tplink.appstore.di.component.DaggerAppComponent;
import com.tplink.appstore.di.module.AppModule;
import com.zhxu.library.RxRetrofitApp;
import com.zhxu.recyclerview.App;


/**
 * <p>Description:
 *
 * @author xzhang
 */

public class StoreApplication extends App {

    private static int mMainThreadId;
    private static Handler mHandler;

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mHandler=new Handler();
        initApplicationComponent();

        RxRetrofitApp.init(this, BuildConfig.DEBUG);
    }

    private void initApplicationComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


    /**
     * 返回主线程的pid
     * @return
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }
    /**
     * 返回Handler
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }

}
