package com.tuean.service;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by zhongxiaotian on 2018/6/11.
 */
public interface IOCRService {


    String identifyByLocal(File file);

    String identifyByRemote(File file);
}
