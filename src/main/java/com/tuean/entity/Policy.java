package com.tuean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import java.util.Date;


/**
 * the policy of the three bid-chances
 */
@Data
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





}
