package com.tuean.steps;

import com.tuean.config.StepConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by zhongxiaotian on 2018/6/4.
 */
public class Starter {

    private static Logger logger = LoggerFactory.getLogger(Starter.class);

    public void start(){
        Iterator iterator = StepConfig.getClassMap().entrySet().iterator();
        if (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Class clazz = (Class) entry.getValue();
            try {
                Method method =  clazz.getMethod("work", StepConfig.class);
                StepConfig.setInstantOrder((Integer) entry.getKey());
                StepConfig stepConfig = StepConfig.getInstance();
                method.invoke(clazz.newInstance(), stepConfig);
            } catch (Exception var){
                var.printStackTrace();
            }
        }
    }

}
