package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ActInfoService {
    /**
      分页查询活动数据列表
    */
    public Map<String, Object> getDataList(ActInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装活动为前台展示的数据形式
    */
    public Map<String, Object> getActInfoModel(ActInfo model, LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(ActInfo model, LoginModel login);

    /**
      修改
    */
    public String update(ActInfo model, LoginModel login);
}

