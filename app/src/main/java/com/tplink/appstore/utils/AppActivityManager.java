package com.tplink.appstore.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by wxmarr on 2017/8/15.
 */

public class AppActivityManager {

    private static Stack<Activity> mActivityStack;
    private static AppActivityManager mAppManager;

    private AppActivityManager() {

    }

    /**
     * 单一实例
     * @return
     */
    public static AppActivityManager getInstance() {
        if (mAppManager == null) {
            mAppManager = new AppActivityManager();
        }
        return mAppManager;
    }


    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<Activity>();
        }
        mActivityStack.add(activity);
    }

    public void removeActivity(Activity activity) {
        mActivityStack.remove(activity);
    }
    
    public Activity getTopActivity() {
        return mActivityStack.lastElement();
    }
    
    public void killTopActivity() {
        Activity activity = mActivityStack.lastElement();
        killActivity(activity);
    }

    private void killActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    public void killActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                killActivity(activity);
            }
        }
    }

    private void killAllActivity() {
        for (int i = 0,size = mActivityStack.size(); i < size; i++) {
            if (mActivityStack.get(i) != null) {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }


    public void AppExit(Context context) {
        killAllActivity();
        ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityMgr.restartPackage(context.getPackageName());
        System.exit(0);
    }

}
