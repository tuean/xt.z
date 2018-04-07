package com.tuean.consont;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhongxiaotian on 2018/4/7.
 */
@Component
public class SystemParam {

    private static Logger logger = LoggerFactory.getLogger(SystemParam.class);

    public static String PROFILE_PATH;

    static{
        logger.info("start to set system params");
        logger.info(System.getProperty("java.class.path"));
        logger.info(System.getProperty("user.dir"));
        PROFILE_PATH = System.getProperty("user.dir");
    }
}
