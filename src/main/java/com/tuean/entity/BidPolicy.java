package com.tuean.entity;

import com.tuean.Exception.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * the policy of the bid process
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

    private Policy instantPolicy;

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

    public Policy getInstantPolicy() throws GlobalException {
        if(this.policyList != null){
            for(Policy policy : this.policyList){
                if(policy.getName().trim().equals(this.instantName.trim())){
                    this.instantPolicy = policy;
                    break;
                }
            }
        }
        if(this.instantPolicy == null){
            throw new GlobalException("instant policy is null");
        }
        return this.instantPolicy;
    }


    @PostConstruct
    public void init() throws GlobalException {
        getInstantPolicy();
        logger.info(this.toString());
    }

}
