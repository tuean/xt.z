package com.tuean.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zhongxiaotian
 * @date 2018/6/22
 */
@Component
@ConfigurationProperties(prefix = "policy")
@PropertySource(value = "classpath:policy.properties")
public class BidPolicy {

    private static Logger logger = LoggerFactory.getLogger(BidPolicy.class);

    private String instantName;

    private List<Policy> policyList = new ArrayList<>();

    /**
     * the policy of the three bid-chances
     */
    public static class Policy{

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

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public long getStartAfterLastSeconds() {
            return startAfterLastSeconds;
        }

        public void setStartAfterLastSeconds(long startAfterLastSeconds) {
            this.startAfterLastSeconds = startAfterLastSeconds;
        }

        public int getExtraMoney() {
            return extraMoney;
        }

        public void setExtraMoney(int extraMoney) {
            this.extraMoney = extraMoney;
        }

        public int getDefinedMonty() {
            return definedMonty;
        }

        public void setDefinedMonty(int definedMonty) {
            this.definedMonty = definedMonty;
        }
    }


    public String getInstantName() {
        return instantName;
    }

    public void setInstantName(String instantName) {
        this.instantName = instantName;
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("instantName:" + instantName);
        if(policyList != null && policyList.size() > 0){
            for(Policy policy : policyList){
                stringBuffer.append(" ");
                stringBuffer.append("name:" + policy.getName());
                stringBuffer.append("type:" + policy.getType());
            }
        }
        return stringBuffer.toString();
    }

    @PostConstruct
    public void init(){
        logger.info(this.toString());
    }

}
