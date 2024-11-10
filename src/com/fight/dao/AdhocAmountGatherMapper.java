package com.fight.dao;

import com.fight.controller.LoginModel;

import com.fight.dao.*;

import com.fight.model.*;

import java.io.InputStream;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AdhocAmountGatherMapper {
    /**
      总收入统计
    */
    public List<Map<String, Object>> amountGather(Map<String, Object> params); //总收入统计

    /**
      总支出统计
    */
    public List<Map<String, Object>> amountGather1(Map<String, Object> params); //总支出统计
}

