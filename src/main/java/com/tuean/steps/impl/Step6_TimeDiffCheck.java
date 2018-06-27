package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.config.StepConfig;
import com.tuean.steps.ISteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author zhongxiaotian
 * @date 2018/6/22
 */
@StepOrder(order = 6)
public class Step6_TimeDiffCheck implements ISteps {

    private static Logger logger = LoggerFactory.getLogger(Step6_TimeDiffCheck.class);

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Override
    public void work() {

        LocalDateTime localDateTime = LocalDateTime.now();
        // todo get remote time
        String remoteTimeString = "2018-06-26 11:30:00";
        LocalDateTime remortDateTime = LocalDateTime.parse(remoteTimeString, formatter);
        Duration duration = Duration.between(localDateTime, remortDateTime);
        Long mills = duration.toMillis();
        logger.info("time diff: {} ms", mills);
        StepConfig.setTimeDiff(mills);

    }
}
