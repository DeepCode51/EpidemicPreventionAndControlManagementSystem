package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface OrderInfoService {
    /**
      分页查询厂商订单数据列表
    */
    public Map<String, Object> getDataList(OrderInfo queryModel, Integer page,
        Integer pageSize, LoginModel login);

    /**
      封装厂商订单为前台展示的数据形式
    */
    public Map<String, Object> getOrderInfoModel(OrderInfo model,
        LoginModel login);

    /**
      认领需求
    */
    public String add(OrderInfo model, LoginModel login);

    /**
      发货
    */
    public String fh(OrderInfo model, LoginModel login);
}

