package com.tuean.helper;

import com.tuean.Swing.JConsole.JConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineLogger {

    private static Logger logger = LoggerFactory.getLogger(MineLogger.class);

    private static JConsole jc;

    public static void setJC(JConsole jcc) {
        jc = jcc;
    }

    public static void log(String s) {
        logger.info(s);
        jc.write(s);
    }


}
