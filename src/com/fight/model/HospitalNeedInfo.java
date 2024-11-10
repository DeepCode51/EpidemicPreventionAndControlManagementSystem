package com.fight.model;

public class HospitalNeedInfo {
    private Integer id;
    private String createTime;
    private Integer wzType;
    private String wzName;
    private Integer wzNum;
    private String remark;
    private Integer hospitalId;
    private Integer completeNum;
    private Integer needStatus;
    private String address;

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

    public Integer getWzType() {
        return wzType;
    }

    public void setWzType(Integer wzType) {
        this.wzType = wzType;
    }

    public String getWzName() {
        return wzName;
    }

    public void setWzName(String wzName) {
        this.wzName = (wzName == null) ? null : wzName.trim();
    }

    public Integer getWzNum() {
        return wzNum;
    }

    public void setWzNum(Integer wzNum) {
        this.wzNum = wzNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = (remark == null) ? null : remark.trim();
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(Integer completeNum) {
        this.completeNum = completeNum;
    }

    public Integer getNeedStatus() {
        return needStatus;
    }

    public void setNeedStatus(Integer needStatus) {
        this.needStatus = needStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = (address == null) ? null : address.trim();
    }
}

