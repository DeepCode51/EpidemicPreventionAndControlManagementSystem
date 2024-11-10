package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface MjInfoService {
    /**
      分页查询募捐信息数据列表
    */
    public Map<String, Object> getDataList(MjInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装募捐信息为前台展示的数据形式
    */
    public Map<String, Object> getMjInfoModel(MjInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增募捐
    */
    public String add(MjInfo model, LoginModel login);

    /**
      修改
    */
    public String update(MjInfo model, LoginModel login);
}

