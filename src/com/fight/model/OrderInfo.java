package com.fight.model;

public class OrderInfo {
    private Integer id;
    private String createTime;
    private Integer needId;
    private String wzName;
    private Integer num;
    private Double price;
    private String outTime;
    private Integer companyId;
    private Integer hospitalId;
    private String hospitalAddress;
    private Integer orderStatus;
    private Double totalAmount;
    private String qrTime;
    private Integer carId;
    private String carType;
    private String contactName;
    private String contactCel;

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

    public Integer getNeedId() {
        return needId;
    }

    public void setNeedId(Integer needId) {
        this.needId = needId;
    }

    public String getWzName() {
        return wzName;
    }

    public void setWzName(String wzName) {
        this.wzName = (wzName == null) ? null : wzName.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = (outTime == null) ? null : outTime.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = (hospitalAddress == null) ? null
                                                         : hospitalAddress.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getQrTime() {
        return qrTime;
    }

    public void setQrTime(String qrTime) {
        this.qrTime = (qrTime == null) ? null : qrTime.trim();
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = (carType == null) ? null : carType.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = (contactName == null) ? null : contactName.trim();
    }

    public String getContactCel() {
        return contactCel;
    }

    public void setContactCel(String contactCel) {
        this.contactCel = (contactCel == null) ? null : contactCel.trim();
    }
}

