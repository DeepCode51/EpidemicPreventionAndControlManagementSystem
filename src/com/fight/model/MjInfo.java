package com.fight.model;

public class MjInfo {
    private Integer id;
    private String createTime;
    private String realName;
    private String jkTime;
    private Double jkAmount;
    private Integer volunteerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = (createTime == null) ? null : createTime.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = (realName == null) ? null : realName.trim();
    }

    public String getJkTime() {
        return jkTime;
    }

    public void setJkTime(String jkTime) {
        this.jkTime = (jkTime == null) ? null : jkTime.trim();
    }

    public Double getJkAmount() {
        return jkAmount;
    }

    public void setJkAmount(Double jkAmount) {
        this.jkAmount = jkAmount;
    }

    public Integer getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
    }
}

