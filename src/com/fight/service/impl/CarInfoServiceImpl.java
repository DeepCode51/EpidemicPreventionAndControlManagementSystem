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
public class CarInfoServiceImpl implements CarInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    CarInfoMapper carInfoMapper;
    @Autowired
    CompanyInfoMapper companyInfoMapper;

    /**
      新增
    */
    @Override
    public String add(CarInfo model, LoginModel login) {
        model.setCompanyId(login.getId()); //登录id
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        carInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(CarInfo model, LoginModel login) {
        CarInfo preModel = carInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setCarType(model.getCarType());
        preModel.setCarNo(model.getCarNo());
        carInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询车辆列表数据
    */
    @Override
    public Map<String, Object> getDataList(CarInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        CarInfoExample se = new CarInfoExample();
        CarInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getCarNo() != null) &&
                (queryModel.getCarNo().equals("") == false)) {
            sc.andCarNoLike("%" + queryModel.getCarNo() + "%"); //模糊查询
        }

        if (queryModel.getCompanyId() != null) {
            sc.andCompanyIdEqualTo(queryModel.getCompanyId());
        }

        int count = (int) carInfoMapper.countByExample(se);
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

        List<CarInfo> list = carInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (CarInfo model : list) {
            list2.add(getCarInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装车辆为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getCarInfoModel(CarInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("carInfo", model);

        if (model.getCompanyId() != null) {
            CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(model.getCompanyId()); //厂商为外接字段,需要关联厂商来解释该字段

            if (companyInfo != null) {
                map.put("companyIdStr", companyInfo.getName());
            }
        }

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        carInfoMapper.deleteByPrimaryKey(id);
    }
}

