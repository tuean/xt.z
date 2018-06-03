package com.tuean.annotation;

import java.lang.annotation.*;

/**
 * Created by zhongxiaotian on 2018/4/30.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface StepOrder {

    int order() default -1;

}
