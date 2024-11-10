package com.fight.service;

import com.fight.controller.LoginModel;

import com.fight.dao.*;

import com.fight.model.*;

import java.io.InputStream;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface NeedGatherService {
    /**
      需求统计
    page:当前页数
    login:当前登录账号
    */
    public Map<String, Object> needGather(Integer page, LoginModel login);
}

