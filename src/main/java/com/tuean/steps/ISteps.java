package com.tuean.steps;

import com.tuean.Exception.GlobalException;
import com.tuean.config.StepConfig;

import java.text.ParseException;

/**
 * Created by zhongxiaotian on 2018/5/1.
 */
public interface ISteps {

    void work() throws GlobalException, ParseException, InterruptedException;
}
