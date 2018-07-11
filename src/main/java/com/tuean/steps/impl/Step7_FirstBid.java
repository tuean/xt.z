package com.tuean.steps.impl;

import com.tuean.Exception.GlobalException;
import com.tuean.annotation.StepOrder;
import com.tuean.config.BidConfig;
import com.tuean.entity.BidPolicy;
import com.tuean.entity.Policy;
import com.tuean.steps.ISteps;
import com.tuean.util.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhongxiaotian on 2018/6/26.
 */
@StepOrder(order = 7)
public class Step7_FirstBid implements ISteps {

    private static Logger logger = LoggerFactory.getLogger(Step7_FirstBid.class);

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private BidPolicy bidPolicy;

    @Override
    public void work() throws GlobalException, ParseException, InterruptedException {



    }

}
