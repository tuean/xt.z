package com.tuean.config;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhongxiaotian on 2018/7/2.
 */
public class BidConfig {

    public BidConfig(){

    }

    public static String bidFinish = "11:30:00";

    private static int instanctPrice = 0;

    private static boolean firstBid;
    private static int firstBidPrice;

    private static boolean secondBid;
    private static int secondBidPrice;

    private static boolean lastBid;
    private static int lastBidPrice;


    public static int getInstanctPrice() {
        return instanctPrice;
    }

    public static void setInstanctPrice(int instanctPrice) {
        BidConfig.instanctPrice = instanctPrice;
    }

    public static boolean isFirstBid() {
        return firstBid;
    }

    public static void setFirstBid(boolean firstBid) {
        BidConfig.firstBid = firstBid;
    }

    public static int getFirstBidPrice() {
        return firstBidPrice;
    }

    public static void setFirstBidPrice(int firstBidPrice) {
        BidConfig.firstBidPrice = firstBidPrice;
    }

    public static boolean isSecondBid() {
        return secondBid;
    }

    public static void setSecondBid(boolean secondBid) {
        BidConfig.secondBid = secondBid;
    }

    public static int getSecondBidPrice() {
        return secondBidPrice;
    }

    public static void setSecondBidPrice(int secondBidPrice) {
        BidConfig.secondBidPrice = secondBidPrice;
    }

    public static boolean isLastBid() {
        return lastBid;
    }

    public static void setLastBid(boolean lastBid) {
        BidConfig.lastBid = lastBid;
    }

    public static int getLastBidPrice() {
        return lastBidPrice;
    }

    public static void setLastBidPrice(int lastBidPrice) {
        BidConfig.lastBidPrice = lastBidPrice;
    }
}

