package com.fight.service.impl;

import com.fight.controller.LoginModel;

import com.fight.dao.*;

import com.fight.model.*;

import com.fight.service.*;

import com.fight.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class AmountGatherServiceImpl implements AmountGatherService {
    @Autowired
    AdhocAmountGatherMapper adhocAmountGatherMapper;
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
      财务收支
    page:当前页数
    login:当前登录账号
    orqrTime1:确认收货日期(最小值)
    orqrTime2:确认收货日期(最大值)
    */
    @Override
    public Map<String, Object> amountGather(Integer page, LoginModel login,
        String orqrTime1, String orqrTime2) {
        Map<String, Object> rs = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("jkTime1", orqrTime1);
        params.put("jkTime2", orqrTime2);

        List<Map<String, Object>> list = adhocAmountGatherMapper.amountGather(params); //总收入统计

        for (Map<String, Object> adhocMap : list) {
        }

        List<String> jkTimeXList = DateCommonUtils.getEchartTimeList(orqrTime1,
                orqrTime2, "yyyy-MM-dd", "yyyy-MM-dd", 3);
        rs.put("jkTimeXList", jkTimeXList);

        List<Map<String, Object>> rsList1 = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            rsList1.add(map);
        }

        rs.put("rsList1", rsList1);

        Map<String, Object> params1 = new HashMap<String, Object>();
        params1.put("qrTime1", orqrTime1);
        params1.put("qrTime2", orqrTime2);

        List<Map<String, Object>> list1 = adhocAmountGatherMapper.amountGather1(params1); //总支出统计

        for (Map<String, Object> adhocMap : list1) {
        }

        List<String> qrTimeXList = DateCommonUtils.getEchartTimeList(orqrTime1,
                orqrTime2, "yyyy-MM-dd", "yyyy-MM-dd", 3);
        rs.put("qrTimeXList", qrTimeXList);

        List<Map<String, Object>> rsList2 = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map1 = list1.get(i);
            rsList2.add(map1);
        }

        rs.put("rsList2", rsList2);

        return rs;
    }
}

