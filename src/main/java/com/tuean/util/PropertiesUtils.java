package com.tuean.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Properties;

/**
 * Created by zhongxiaotian on 2018/7/10.
 */
public class PropertiesUtils {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

    private static Properties bidProp = new Properties();
    private static Properties policyProp = new Properties();


    static {
        loadProperty(bidProp, "bid.properties");
        loadProperty(policyProp, "policy.properties");
    }


    public static void loadProperty(Properties prop, String fileName){
        InputStream input = null;
        try {
            input = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
            prop.load(input);
        } catch (FileNotFoundException var1){
            logger.error("{} file not found！", fileName);
        } catch (IOException var2) {
            logger.error("{} file read error！", fileName);
        } finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String bidGet(String key){
        return String.valueOf(bidProp.get(key));
    }

    public void storePolicy(Properties properties, String filePreName) {
//        String filePath =
//        OutputStream out = new FileOutputStream();
//        properties.store();
    }

}
