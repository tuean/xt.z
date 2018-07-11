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
@Component
public class PropertiesUtils {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

    private Properties prop = new Properties();


    public void loadProperty(String fileName){
        InputStream input = null;
        try {
            input = new FileInputStream("bid.properties");
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

    @PostConstruct
    public void init(){
        loadProperty("bid.properties");
    }

    public String get(String key){
        Properties properties = this.getProp();
        if(properties == null){
            this.init();
        }
        if(properties == null){
            return null;
        }
        return String.valueOf(this.getProp().get(key));
    }


    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }
}
