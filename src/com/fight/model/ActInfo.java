package com.fight.model;

public class ActInfo {
    private Integer id;
    private String createTime;
    private String actTitle;
    private String actContent;
    private String actImg;

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

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = (actTitle == null) ? null : actTitle.trim();
    }

    public String getActContent() {
        return actContent;
    }

    public void setActContent(String actContent) {
        this.actContent = (actContent == null) ? null : actContent.trim();
    }

    public String getActImg() {
        return actImg;
    }

    public void setActImg(String actImg) {
        this.actImg = (actImg == null) ? null : actImg.trim();
    }
}

