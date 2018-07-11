package com.tuean.steps.impl;

import com.tuean.Exception.GlobalException;
import com.tuean.annotation.StepOrder;
import com.tuean.config.BidConfig;
import com.tuean.entity.BidPolicy;
import com.tuean.entity.Policy;
import com.tuean.steps.ISteps;
import com.tuean.util.TimeUtils;
import javafx.scene.input.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhongxiaotian on 2018/7/2.
 */
@StepOrder(order = 10)
public class Step10_SecondBid implements ISteps{

    private static Logger logger = LoggerFactory.getLogger(Step10_SecondBid.class);

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private BidPolicy bidPolicy;

    @Override
    public void work() throws GlobalException, ParseException, InterruptedException {
        logger.info("instant price is {}", BidConfig.getInstanctPrice());
        logger.info("start 2sd bid");
        Policy policy = bidPolicy.getInstantPolicy(); // instant policy
        Assert.notNull(policy, "instant policy is null");
        Date bidTime = null;
        Integer bidPrice = null;

        if (policy.getSecondBidTime() != null && bidTime == null) {
            bidTime = policy.getSecondBidTime();
        }
        if (policy.getSecondBidBeforeEnd() != null && bidTime == null) {
            Date endTime = sdf.parse(BidConfig.bidFinish);
            bidTime = TimeUtils.getSecondsBefore(endTime, policy.getSecondBidBeforeEnd());
        }

        if (policy.getDefinedSecondMonty() > 0 && bidPrice == null) {
            bidPrice = policy.getDefinedSecondMonty();
        }
        if (policy.getExtraSecondMoney() > 0 && bidPrice == null) {
            bidPrice = BidConfig.getInstanctPrice();
        }

        Assert.notNull(bidTime, "second bid time is null");
        Assert.notNull(bidPrice, "second bid price is null");

        Date date;
        while(true){
            date = new Date();
            logger.info("instant time is :" + sdf.format(date));
            if(date.after(bidTime)){
                logger.info("got to do second price action");
                // todo do price action


                logger.info("do second bid success and price is :" + bidPrice);
                break;
            }
            Thread.sleep(10);
        }
    }
}
