package com.tplink.appstore.base;

import android.os.Handler;
import android.util.Log;

import com.zhxu.recyclerview.App;


/**
 * <p>Description:
 *
 * @author xzhang
 */

public class StoreApplication extends App {

    private static int mMainThreadId;
    private static Handler mHandler;


    @Override
    public void onCreate() {
        super.onCreate();
        mHandler=new Handler();
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
