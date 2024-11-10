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
public class MjInfoServiceImpl implements MjInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    MjInfoMapper mjInfoMapper;
    @Autowired
    VolunteerInfoMapper volunteerInfoMapper;

    /**
      新增募捐
    */
    @Override
    public String add(MjInfo model, LoginModel login) {
        model.setVolunteerId(login.getId()); //登录id
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        mjInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(MjInfo model, LoginModel login) {
        MjInfo preModel = mjInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setRealName(model.getRealName());
        preModel.setJkTime(model.getJkTime());
        preModel.setJkAmount(model.getJkAmount());
        mjInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询募捐信息列表数据
    */
    @Override
    public Map<String, Object> getDataList(MjInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        MjInfoExample se = new MjInfoExample();
        MjInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getRealName() != null) &&
                (queryModel.getRealName().equals("") == false)) {
            sc.andRealNameLike("%" + queryModel.getRealName() + "%"); //模糊查询
        }

        if (queryModel.getVolunteerId() != null) {
            sc.andVolunteerIdEqualTo(queryModel.getVolunteerId());
        }

        int count = (int) mjInfoMapper.countByExample(se);
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

        List<MjInfo> list = mjInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (MjInfo model : list) {
            list2.add(getMjInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装募捐信息为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getMjInfoModel(MjInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mjInfo", model);

        if (model.getVolunteerId() != null) {
            VolunteerInfo volunteerInfo = volunteerInfoMapper.selectByPrimaryKey(model.getVolunteerId()); //志愿者id为外接字段,需要关联志愿者来解释该字段

            if (volunteerInfo != null) {
                map.put("volunteerIdStr", volunteerInfo.getName());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        mjInfoMapper.deleteByPrimaryKey(id);
    }
}

