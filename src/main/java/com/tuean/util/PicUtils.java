package com.tuean.util;

import com.tuean.config.StepConfig;
import com.tuean.steps.impl.PreConfigs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by zhongxiaotian on 2018/6/3.
 */
public class PicUtils {


    public static File getScreenshot(StepConfig stepConfig, String filePath){
        WebDriver webDriver = stepConfig.getWebDriver();
        File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try{
            File resultFile = new File(filePath);
            FileUtils.copyFile(srcFile, resultFile);
            return resultFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File getScreenshotByDefaultPath(StepConfig stepConfig){
        return getScreenshot(stepConfig, getDefaultPicUrl());
    }


    public static File getSpecifiedScreenShot(StepConfig stepConfig, int x, int y, int w, int h){
        File wholeScreen = getScreenshotByDefaultPath(stepConfig);
        return cutImage(wholeScreen, x, y, w, h);
    }

    public static File cutImage(File file, int x, int y, int w, int h) {
        try {
            ImageInputStream iis = ImageIO.createImageInputStream(new FileInputStream(file));
            // 再按照指定格式构造一个Reader（Reader不能new的）
            Iterator it = ImageIO.getImageReadersByFormatName("png");
            ImageReader imagereader = (ImageReader) it.next();
            // 再通过ImageReader绑定 InputStream
            imagereader.setInput(iis);

            // 设置感兴趣的源区域。
            ImageReadParam par = imagereader.getDefaultReadParam();
            par.setSourceRegion(new Rectangle(x, y, w, h));
            // 从 reader得到BufferImage
            BufferedImage bi = imagereader.read(0, par);

            // 将BuffeerImage写出通过ImageIO
            File resultFile = new File(getDefaultPicUrl());
            ImageIO.write(bi, "png", resultFile);
            return resultFile;
        } catch (Exception var){
            var.printStackTrace();
        }
        return null;
    }


    public static String getDefaultPicUrl(){
        return PreConfigs.defaultFilePath() + System.currentTimeMillis() + ".jpg";
    }

}
