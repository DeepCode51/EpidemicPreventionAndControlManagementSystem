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

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class HospitalInfoServiceImpl implements HospitalInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    HospitalInfoMapper hospitalInfoMapper;

    /**
      新增
    */
    @Override
    public String add(HospitalInfo model, LoginModel login) {
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        hospitalInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(HospitalInfo model, LoginModel login) {
        HospitalInfo preModel = hospitalInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setName(model.getName());
        preModel.setPassWord(model.getPassWord());
        preModel.setHospitalName(model.getHospitalName());
        preModel.setAddress(model.getAddress());
        hospitalInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询医院列表数据
    */
    @Override
    public Map<String, Object> getDataList(HospitalInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        HospitalInfoExample se = new HospitalInfoExample();
        HospitalInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getName() != null) &&
                (queryModel.getName().equals("") == false)) {
            sc.andNameLike("%" + queryModel.getName() + "%"); //模糊查询
        }

        if ((queryModel.getHospitalName() != null) &&
                (queryModel.getHospitalName().equals("") == false)) {
            sc.andHospitalNameLike("%" + queryModel.getHospitalName() + "%"); //模糊查询
        }

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        int count = (int) hospitalInfoMapper.countByExample(se);
        int totalPage = 0;

        if ((page != null) && (pageSize != null)) { //分页

            if ((count > 0) && ((count % pageSize) == 0)) {
                totalPage = count / pageSize;
            } else {
                totalPage = (count / pageSize) + 1;
            }

            se.setPageRows(pageSize);
            se.setStartRow((page - 1) * pageSize);
        }

        List<HospitalInfo> list = hospitalInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (HospitalInfo model : list) {
            list2.add(getHospitalInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装医院为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getHospitalInfoModel(HospitalInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hospitalInfo", model);

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        hospitalInfoMapper.deleteByPrimaryKey(id);
    }
}

