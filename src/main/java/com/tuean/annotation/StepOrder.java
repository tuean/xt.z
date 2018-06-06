package com.tuean.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by zhongxiaotian on 2018/4/30.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface StepOrder {

    int order() default -1;

}
