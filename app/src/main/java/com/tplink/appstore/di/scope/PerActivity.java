package com.tplink.appstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by wxmarr on 2017/8/27.
 *
 * 自定义Scope限定作用域
 */


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
