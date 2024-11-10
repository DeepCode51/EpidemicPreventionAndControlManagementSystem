package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.dao.*;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AmountGatherService {
    /**
      财务收支
    page:当前页数
    login:当前登录账号
    orqrTime1:确认收货日期(最小值)
    orqrTime2:确认收货日期(最大值)
    */
    public Map<String, Object> amountGather(Integer page, LoginModel login,
        String orqrTime1, String orqrTime2);
}

