//package com.tuean.lab;
//
//import com.alibaba.fastjson.JSON;
//import com.google.common.io.ByteStreams;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.*;
//
///**
// * Created by zhongxiaotian on 2018/7/3.
// */
//public class ExecTest {
//
//    public static void main(String[] args) throws IOException, InterruptedException {
////        Object r = Runtime.getRuntime().exec("ls");
////        System.out.println(JSON.toJSONString(r));
//
////        String str = JOptionPane.showInputDialog("输入验证码:");
////        System.out.println(str);
//
//
////        MacOs : Runtime.getRuntime.exec("/usr/bin/open -a Terminal /path/to/the/executable");
////        Linux : Runtime.getRuntime.exec("/usr/bin/xterm");
////        Windows (not sure ) :
////
////        Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe"); p.waitFor();
//
//        Process pro =  Runtime.getRuntime().exec("/usr/bin/open -a  iterm ");
//        pro.waitFor();
//        while(pro.isAlive()){
//            InputStream in = pro.getInputStream();
//            String x = new String(ByteStreams.toByteArray(in));
//            if(x != null && !"".equals(x.trim())){
//                System.out.println("input:" + x);
//            }
//            OutputStream out = pro.getOutputStream();
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            out.write(baos.toByteArray());
//            String xo = baos.toString();
//            if(xo != null && !"".equals(xo.trim())){
//                System.out.println("output:" + xo);
//            }
//        }
//    }
//}
