package com.tuean.config;

public class LoginConfig {

    /**
     * 标书号
     */
    private String user;

    /**
     * 标书密码
     */
    private String password;

    /**
     * 身份证
     */
    private String identify;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }
}
