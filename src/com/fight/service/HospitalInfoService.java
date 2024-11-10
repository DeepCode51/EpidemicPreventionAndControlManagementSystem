package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface HospitalInfoService {
    /**
      分页查询医院数据列表
    */
    public Map<String, Object> getDataList(HospitalInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装医院为前台展示的数据形式
    */
    public Map<String, Object> getHospitalInfoModel(HospitalInfo model,
        LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(HospitalInfo model, LoginModel login);

    /**
      修改
    */
    public String update(HospitalInfo model, LoginModel login);
}

