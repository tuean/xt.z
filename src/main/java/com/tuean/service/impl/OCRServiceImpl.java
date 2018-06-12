package com.tuean.service.impl;

import com.tuean.service.IOCRService;
import com.tuean.util.PicUtils;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by zhongxiaotian on 2018/6/11.
 */
@Component
public class OCRServiceImpl implements IOCRService {


    @Override
    public String identifyByLocal(File file) {
        return PicUtils.img2String(file);
    }

    @Override
    public String identifyByRemote(File file) {
        return null;
    }
}
