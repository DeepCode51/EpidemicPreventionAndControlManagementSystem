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
public class VolunteerInfoServiceImpl implements VolunteerInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    VolunteerInfoMapper volunteerInfoMapper;

    /**
      新增
    */
    @Override
    public String add(VolunteerInfo model, LoginModel login) {
        String check = checkData(model, 1); //检查数据是否符合要求

        if (check.equals("") == false) {
            return check;
        }

        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        volunteerInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(VolunteerInfo model, LoginModel login) {
        VolunteerInfo preModel = volunteerInfoMapper.selectByPrimaryKey(model.getId());
        String check1 = checkData(model, 2); //检查数据是否合法

        if (check1.equals("") == false) {
            return check1;
        }

        preModel.setName(model.getName());
        preModel.setPassWord(model.getPassWord());
        preModel.setVolunteerName(model.getVolunteerName());
        preModel.setVolunteerCel(model.getVolunteerCel());
        volunteerInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update2(VolunteerInfo model, LoginModel login) {
        VolunteerInfo preModel = volunteerInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setVolunteerName(model.getVolunteerName());
        preModel.setVolunteerCel(model.getVolunteerCel());
        volunteerInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询志愿者列表数据
    */
    @Override
    public Map<String, Object> getDataList(VolunteerInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        VolunteerInfoExample se = new VolunteerInfoExample();
        VolunteerInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getName() != null) &&
                (queryModel.getName().equals("") == false)) {
            sc.andNameLike("%" + queryModel.getName() + "%"); //模糊查询
        }

        if ((queryModel.getVolunteerName() != null) &&
                (queryModel.getVolunteerName().equals("") == false)) {
            sc.andVolunteerNameLike("%" + queryModel.getVolunteerName() + "%"); //模糊查询
        }

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        int count = (int) volunteerInfoMapper.countByExample(se);
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

        List<VolunteerInfo> list = volunteerInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (VolunteerInfo model : list) {
            list2.add(getVolunteerInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装志愿者为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getVolunteerInfoModel(VolunteerInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("volunteerInfo", model);

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        volunteerInfoMapper.deleteByPrimaryKey(id);
    }

    public String checkData(VolunteerInfo model, Integer type) { //type=1 表示新增操作,type=2 表示修改操作,type=3 表示修改操作,

        if ((type == 1) || (type == 2)) {
            if (model.getName() != null) {
                VolunteerInfoExample te = new VolunteerInfoExample();
                VolunteerInfoExample.Criteria tc = te.createCriteria();
                tc.andNameEqualTo(model.getName());

                if (type == 2) {
                    tc.andIdNotEqualTo(model.getId());
                }

                int count = (int) volunteerInfoMapper.countByExample(te);

                if (count > 0) {
                    return "系统已存在" +
                    model.getName() +
                    "值,登录名属性值不允许重复";
                }
            }
        }

        if ((type == 1) || (type == 2) || (type == 3)) {
            if (model.getVolunteerCel() != null) {
                Pattern p = Pattern.compile(
                        "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
                Matcher m = p.matcher(model.getVolunteerCel());

                if (m.matches() == false) {
                    return "请输入正确的联系号码";
                }
            }
        }

        return "";
    }
}

