package com.tuean.task;

import com.tuean.config.StepConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDiffCheckTask {

    private static Logger logger = LoggerFactory.getLogger(TimeDiffCheckTask.class);

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    public void run() {
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
