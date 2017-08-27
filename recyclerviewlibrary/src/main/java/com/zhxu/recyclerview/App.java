package com.zhxu.recyclerview;

import android.app.Application;
import android.util.Log;

/**
 * <p>Description:
 *
 * @author xzhang
 */

public class App extends Application {

    public static App context ;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("mawenxuan","oncreate application");
        context = this ;
    }

    public static App getContext(){
        return context;
    }
}
