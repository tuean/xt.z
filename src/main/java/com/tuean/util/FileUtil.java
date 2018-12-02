package com.tuean.util;

import java.io.File;

/**
 * Created by zhongxiaotian on 2018/4/7.
 */
public class FileUtil {


    public static String getProjectPath() {
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        return dir.toString();
    }

}
