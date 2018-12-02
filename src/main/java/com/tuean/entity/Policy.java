package com.tuean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;


/**
 * the policy of the three bid-chances
 */
public class Policy{

    /**
     * name of policy
     */
    private String name;

    /**
     * type of policy
     */
    private String type;

    /**
     * define a time that first bid works
     * null means first offer immediately
     */
    @JSONField(format = "HH:mm:ss")
    private Date firstBidTime;

    /**
     * define a time that second bid works
     */
    @JSONField(format = "HH:mm:ss")
    private Date secondBidTime;

    /**
     * define seconds that before end
     */
    private Long secondBidBeforeEnd;

    /**
     * define a time that last bid works
     */
    @JSONField(format = "HH:mm:ss")
    private Date lastBidTime;

    /**
     * define seconds that before end
     */
    private Long lastBidBeforeEnd;

    /**
     * define additional money above second price
     */
    private int extraSecondMoney;

    /**
     * define decided price
     */
    private int definedSecondMonty;

    /**
     * define additional money above last price
     */
    private int extraLastMoney;

    /**
     * define decided price
     */
    private int definedLastMonty;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getFirstBidTime() {
        return firstBidTime;
    }

    public void setFirstBidTime(Date firstBidTime) {
        this.firstBidTime = firstBidTime;
    }

    public Date getSecondBidTime() {
        return secondBidTime;
    }

    public void setSecondBidTime(Date secondBidTime) {
        this.secondBidTime = secondBidTime;
    }

    public Long getSecondBidBeforeEnd() {
        return secondBidBeforeEnd;
    }

    public void setSecondBidBeforeEnd(Long secondBidBeforeEnd) {
        this.secondBidBeforeEnd = secondBidBeforeEnd;
    }

    public Date getLastBidTime() {
        return lastBidTime;
    }

    public void setLastBidTime(Date lastBidTime) {
        this.lastBidTime = lastBidTime;
    }

    public Long getLastBidBeforeEnd() {
        return lastBidBeforeEnd;
    }

    public void setLastBidBeforeEnd(Long lastBidBeforeEnd) {
        this.lastBidBeforeEnd = lastBidBeforeEnd;
    }

    public int getExtraSecondMoney() {
        return extraSecondMoney;
    }

    public void setExtraSecondMoney(int extraSecondMoney) {
        this.extraSecondMoney = extraSecondMoney;
    }

    public int getDefinedSecondMonty() {
        return definedSecondMonty;
    }

    public void setDefinedSecondMonty(int definedSecondMonty) {
        this.definedSecondMonty = definedSecondMonty;
    }

    public int getExtraLastMoney() {
        return extraLastMoney;
    }

    public void setExtraLastMoney(int extraLastMoney) {
        this.extraLastMoney = extraLastMoney;
    }

    public int getDefinedLastMonty() {
        return definedLastMonty;
    }

    public void setDefinedLastMonty(int definedLastMonty) {
        this.definedLastMonty = definedLastMonty;
    }
}
