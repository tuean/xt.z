package com.tuean.util;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.tuean.annotation.StepOrder;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by zhongxiaotian on 2018/5/1.
 */
public class ReflectionUtls {

    /**
     * 通过指定的路径获取其下所有指定注解标注的类列表
     *
     * @param packageDir
     * @return
     */
    public static List<Class> getClassByPackage(String packageDir){
        List<Class> list = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            assert classLoader != null;
            String path = packageDir.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            List<File> dirs = new ArrayList<File>();
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                dirs.add(new File(resource.getFile()));
            }
            for (File directory : dirs) {
                list.addAll(findClasses(directory, packageDir));
            }

        } catch (IOException | ClassNotFoundException var){

        }
        return list;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                Class tmp = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                StepOrder stepOrder = (StepOrder) tmp.getAnnotation(StepOrder.class);
                if(stepOrder != null){
                    int order = stepOrder.order();
                    classes.add(order, tmp);
                }
            }
        }
        return classes;
    }

    public static void main(String[] args) {
        getClassByPackage("com.tuean.steps");
    }
}
