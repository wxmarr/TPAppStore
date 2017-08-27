package com.tplink.appstore.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.tplink.appstore.R;
import com.tplink.appstore.utils.UIUtils;

/**
 * Created by wxmarr on 2017/8/24.
 */

public abstract class LoadingPager extends FrameLayout {


    /**
     * 默认状态
     */
    public final static int STATE_UNKOWN = 0;

    /**
     * 加载中状态
     */

    public final static int STATE_LOADING = 1;

    /**
     * 加载失败状态
     */
    public final static int STATE_ERROR = 2;

    /**
     * 加载成功状态
     */
    public final static int STATE_SUCCESS = 3;

    /**
     * 加载空状态
     */
    public final static int STATE_EMPTY = 4;

    // 4种界面如何显示？可以将这四种界面添加到帧布局中，根据状态显示不同的布局
    private View loadingView;
    private View errorView;
    private View emptyView;
    private View successView;

    private int state = STATE_EMPTY;

    public LoadingPager(@NonNull Context context) {
        super(context);
        init();
    }

    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LoadingPager(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        if (loadingView == null) {
            loadingView = createLoadingView();
            this.addView(loadingView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        }
        if (errorView == null) {
            errorView = createErrorView();
            this.addView(errorView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        }
        if (emptyView == null) {
            emptyView = createEmptyView();
            this.addView(emptyView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        }
        showPager();
    }

    private View createEmptyView() {
        return UIUtils.inflate(R.layout.loading_page_empty);
    }

    private View createErrorView() {
        View view = UIUtils.inflate(R.layout.loading_error_page);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
        return view;
    }

    private View createLoadingView() {
        return UIUtils.inflate(R.layout.loading_page);
    }





    /**
     * 请求网络，修改状态
     */
    public void show() {
        if (state == STATE_UNKOWN || state == STATE_EMPTY || state == STATE_ERROR) {
            state = STATE_LOADING;
            load();
        }
        showPager();
    }

    /**
     * 根据不同状态显示不同的布局
     */
    private void showPager() {

        if(loadingView != null){
            loadingView.setVisibility(state == STATE_LOADING || state == STATE_UNKOWN ? View.VISIBLE : View.GONE);
        }
        if(errorView != null){
            errorView.setVisibility(state == STATE_ERROR ? View.VISIBLE : View.GONE);
        }
        if(emptyView != null){
            emptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE : View.GONE);
        }
        if(state == STATE_SUCCESS && successView == null){
            successView = createSuccessView();
            this.addView(successView,new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        }
    }

    public void setState(LoadResult result) {
        state = result.getValue();
        UIUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showPager();
            }
        });

    }

    public enum LoadResult {
        error(STATE_ERROR),success(STATE_SUCCESS),empty(STATE_EMPTY);
        int value;
        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    protected abstract void load();
    protected abstract View createSuccessView();
}
