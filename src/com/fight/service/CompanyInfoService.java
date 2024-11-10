package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CompanyInfoService {
    /**
      分页查询厂商数据列表
    */
    public Map<String, Object> getDataList(CompanyInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装厂商为前台展示的数据形式
    */
    public Map<String, Object> getCompanyInfoModel(CompanyInfo model,
        LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(CompanyInfo model, LoginModel login);

    /**
      修改
    */
    public String update(CompanyInfo model, LoginModel login);
}

