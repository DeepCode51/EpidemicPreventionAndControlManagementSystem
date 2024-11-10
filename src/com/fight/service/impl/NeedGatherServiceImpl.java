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
public class NeedGatherServiceImpl implements NeedGatherService {
    @Autowired
    AdhocNeedGatherMapper adhocNeedGatherMapper;
    @Autowired
    HospitalInfoMapper hospitalInfoMapper;
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
      需求统计
    page:当前页数
    login:当前登录账号
    */
    @Override
    public Map<String, Object> needGather(Integer page, LoginModel login) {
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list = adhocNeedGatherMapper.needGather(); //总需求统计

        for (Map<String, Object> adhocMap : list) {
            if (adhocMap.get("col2") != null) {
                HospitalInfo model = hospitalInfoMapper.selectByPrimaryKey(Integer.parseInt(
                            adhocMap.get("col2").toString()));

                if (model != null) {
                    String col2Str = "";
                    col2Str += model.getHospitalName();
                    adhocMap.put("col2Str", col2Str);
                }
            }
        }

        HospitalInfoExample hospitalInfoE = new HospitalInfoExample();
        HospitalInfoExample.Criteria hospitalInfoC = hospitalInfoE.createCriteria();

        if (login.getLoginType() == 2) {
            hospitalInfoC.andIdEqualTo(login.getId());
        }

        List<HospitalInfo> hospitalInfoXList = hospitalInfoMapper.selectByExample(hospitalInfoE); //得到x轴数据列表
        List<Map<String, String>> hospitalInfoXList2 = new ArrayList<Map<String, String>>();

        for (HospitalInfo tmp : hospitalInfoXList) {
            Map<String, String> hospitalInfoXMap = new HashMap<String, String>();
            String showXVal = "";

            showXVal += tmp.getHospitalName();
            hospitalInfoXMap.put("name", showXVal);
            hospitalInfoXMap.put("id", tmp.getId() + "");
            hospitalInfoXList2.add(hospitalInfoXMap);
        }

        rs.put("hospitalIdXList", hospitalInfoXList2);

        List<Map<String, Object>> rsList1 = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            rsList1.add(map);
        }

        rs.put("rsList1", rsList1);

        List<Map<String, Object>> list1 = adhocNeedGatherMapper.needGather1(); //已完成需求

        for (Map<String, Object> adhocMap : list1) {
            if (adhocMap.get("col1") != null) {
                HospitalInfo model1 = hospitalInfoMapper.selectByPrimaryKey(Integer.parseInt(
                            adhocMap.get("col1").toString()));

                if (model1 != null) {
                    String col1Str = "";
                    col1Str += model1.getHospitalName();
                    adhocMap.put("col1Str", col1Str);
                }
            }
        }

        HospitalInfoExample hospitalInfoE1 = new HospitalInfoExample();
        HospitalInfoExample.Criteria hospitalInfoC1 = hospitalInfoE1.createCriteria();

        if (login.getLoginType() == 2) {
            hospitalInfoC1.andIdEqualTo(login.getId());
        }


        rs.put("hospitalIdXList", hospitalInfoXList2);

        List<Map<String, Object>> rsList2 = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map1 = list1.get(i);
            rsList2.add(map1);
        }

        rs.put("rsList2", rsList2);

        return rs;
    }
}

