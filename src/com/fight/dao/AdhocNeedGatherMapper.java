package com.fight.dao;

import com.fight.controller.LoginModel;

import com.fight.dao.*;

import com.fight.model.*;

import java.io.InputStream;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AdhocNeedGatherMapper {
    /**
      总需求统计
    */
    public List<Map<String, Object>> needGather();

    /**
      已完成需求
    */
    public List<Map<String, Object>> needGather1();
}

