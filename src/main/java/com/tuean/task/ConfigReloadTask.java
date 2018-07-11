package com.tuean.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhongxiaotian on 2018/7/5.
 */
@Component
public class ConfigReloadTask {

    private static Logger logger = LoggerFactory.getLogger(ConfigReloadTask.class);

    @Autowired
    private StandardEnvironment environment;

    @Scheduled(fixedRate=1000)
    public void reload() throws IOException {

        logger.info(environment.getProperty("bid.url"));

        MutablePropertySources propertySources = environment.getPropertySources();
        PropertySource<?> resourcePropertySource = propertySources.get("class path resource [bid.properties]");
        Properties properties = new Properties();
        File file = ResourceUtils.getFile("classpath:bid.properties");
        InputStream inputStream = new FileInputStream(file);
        properties.load(inputStream);
        inputStream.close();
        propertySources.replace("class path resource [bid.properties]", new PropertiesPropertySource("class path resource [bid.properties]", properties));


    }
}
