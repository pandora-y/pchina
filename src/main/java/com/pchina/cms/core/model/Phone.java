package com.pchina.cms.core.model;

import java.util.Date;

public class Phone {
    private Long id;

    private String phone;

    private String operatorsCornet;

    private String operatorsId;

    private String uniqueIdentifier;

    private String operators;

    private String country;

    private Date createTime;

    private String keyword;

    private Long pushFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOperatorsCornet() {
        return operatorsCornet;
    }

    public void setOperatorsCornet(String operatorsCornet) {
        this.operatorsCornet = operatorsCornet == null ? null : operatorsCornet.trim();
    }

    public String getOperatorsId() {
        return operatorsId;
    }

    public void setOperatorsId(String operatorsId) {
        this.operatorsId = operatorsId == null ? null : operatorsId.trim();
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier == null ? null : uniqueIdentifier.trim();
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators == null ? null : operators.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Long getPushFlag() {
        return pushFlag;
    }

    public void setPushFlag(Long pushFlag) {
        this.pushFlag = pushFlag;
    }
}