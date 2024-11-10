package com.fight.model;

public class VolunteerInfo {
    private Integer id;
    private String name;
    private String passWord;
    private String createTime;
    private String volunteerName;
    private String volunteerCel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name == null) ? null : name.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = (passWord == null) ? null : passWord.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = (createTime == null) ? null : createTime.trim();
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = (volunteerName == null) ? null : volunteerName.trim();
    }

    public String getVolunteerCel() {
        return volunteerCel;
    }

    public void setVolunteerCel(String volunteerCel) {
        this.volunteerCel = (volunteerCel == null) ? null : volunteerCel.trim();
    }
}

