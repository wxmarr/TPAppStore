package com.tplink.appstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by wxmarr on 2017/8/27.
 *
 * 限定符
 *
 * 限定Context生命周期
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextLife {

    String value() default "";
}
