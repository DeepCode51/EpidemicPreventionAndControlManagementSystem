package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface VolunteerInfoService {
    /**
      分页查询志愿者数据列表
    */
    public Map<String, Object> getDataList(VolunteerInfo queryModel,
        Integer page, Integer pageSize, LoginModel login);

    /**
      封装志愿者为前台展示的数据形式
    */
    public Map<String, Object> getVolunteerInfoModel(VolunteerInfo model,
        LoginModel login);

    /**
    * 删除数据
    */
    public void delete(Integer id);

    /**
      新增
    */
    public String add(VolunteerInfo model, LoginModel login);

    /**
      修改
    */
    public String update(VolunteerInfo model, LoginModel login);

    /**
      修改
    */
    public String update2(VolunteerInfo model, LoginModel login);
}

