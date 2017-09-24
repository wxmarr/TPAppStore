package com.tplink.appstore.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;

import com.tplink.appstore.R;
import com.tplink.appstore.utils.AppActivityManager;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Created by wxmarr on 2017/8/15.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected ViewGroup title_bar = null ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initLayout();
        ButterKnife.bind(this);
        initView();


    }



    private void setStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            title_bar = (ViewGroup) findViewById(R.id.bar_layout);
//            final int statusHeight = getStatusBarHeight();
//            title_bar.post(new Runnable() {
//                @Override
//                public void run() {
//                    int titleHeight = title_bar.getHeight();
//                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) title_bar.getLayoutParams();
//                    params.height = statusHeight;
//                    title_bar.setLayoutParams(params);
//                }
//            });
        }
    }

    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj= c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelOffset(x);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 初始化布局，需要子类自己实现
     */
    protected abstract void initLayout();

    /**初始化view，需要子类自己实现
     *
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected void initData(){}

    /**
     * 所有Activity的动画都一样
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);
    }

    protected void openActivity(Class clazz) {
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_right);
    }

    @Override
    protected void onDestroy() {
        AppActivityManager.getInstance().removeActivity(this);
        super.onDestroy();

        fixInputMethodManagerLeak(this);
    }

    private void fixInputMethodManagerLeak(BaseActivity baseActivity) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
