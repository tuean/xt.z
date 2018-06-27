package com.tuean.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 *
 * @author zhongxiaotian
 * @date 2018/6/22
 */
@Component
@ConfigurationProperties(prefix = "policy")
public class BidPolicy {


    private String instantName;

    private List<Policy> policyList;

    /**
     * the policy of the three bid-chances
     */
    class Policy{

        /**
         * name of policy
         */
        private String name;

        /**
         * type of policy
         */
        private String type;

        /**
         * define a time that works
         */
        private Date startTime;

        /**
         * define seconds that works after some time
         */
        private long startAfterLastSeconds;

        /**
         * define additional money above last price
         */
        private int extraMoney;

        /**
         * define decided price
         */
        private int definedMonty;

    }


    public String getInstantName() {
        return instantName;
    }

    public void setInstantName(String instantName) {
        this.instantName = instantName;
    }
}
