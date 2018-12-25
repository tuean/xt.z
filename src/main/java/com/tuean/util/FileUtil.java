package com.tuean.util;

import com.tuean.consont.SystemParam;

import java.io.File;

/**
 * Created by zhongxiaotian on 2018/4/7.
 */
public class FileUtil {


    /**
     * get runtime path of the jar file
     *
     * @return
     */
    public static String getProjectPath() {
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        return dir.toString();
    }

    /**
     * output the file content of the tmp
     *
     * @return path
     */
    public static String defaultFilePath(){
        String path = SystemParam.PROJECT_PATH + "/tmp/";
        // to check if run in the debug mode
        if (path.length() > 1000) {
            path = "/Users/tuean/Desktop/tmp/";
        }
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    public static void main(String[] args) {
        System.out.println(defaultFilePath());
    }

}
