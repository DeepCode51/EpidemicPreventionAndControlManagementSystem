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
public class HospitalNeedInfoServiceImpl implements HospitalNeedInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    HospitalNeedInfoMapper hospitalNeedInfoMapper;
    @Autowired
    HospitalInfoMapper hospitalInfoMapper;

    /**
      发布需求
    */
    @Override
    public String add(HospitalNeedInfo model, LoginModel login) {
        model.setHospitalId(login.getId()); //登录id
        model.setCompleteNum(0); //默认0
        model.setNeedStatus(1); //默认草稿,
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式

        HospitalInfo hospitalInfo = hospitalInfoMapper.selectByPrimaryKey(model.getHospitalId()); //查询医院供以下填入其他字段

        if (hospitalInfo != null) {
            model.setAddress(hospitalInfo.getAddress());
        }
        if(model.getWzType()!=4){
        	model.setWzName(DataListUtils.getWzTypeNameById(model.getWzType()+""));
        }

        hospitalNeedInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(HospitalNeedInfo model, LoginModel login) {
        HospitalNeedInfo preModel = hospitalNeedInfoMapper.selectByPrimaryKey(model.getId());
        preModel.setWzType(model.getWzType());
        preModel.setWzName(model.getWzName());
        preModel.setWzNum(model.getWzNum());
        preModel.setRemark(model.getRemark());
        preModel.setAddress(model.getAddress());
        if(model.getWzType()!=4){
        	model.setWzName(DataListUtils.getWzTypeNameById(model.getWzType()+""));
        }
        hospitalNeedInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询医院需求列表数据
    */
    @Override
    public Map<String, Object> getDataList(HospitalNeedInfo queryModel,
        Integer page, Integer pageSize, LoginModel login) {
        HospitalNeedInfoExample se = new HospitalNeedInfoExample();
        HospitalNeedInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getWzName() != null) &&
                (queryModel.getWzName().equals("") == false)) {
            sc.andWzNameLike("%" + queryModel.getWzName() + "%"); //模糊查询
        }

        if (queryModel.getNeedStatus() != null) {
            sc.andNeedStatusEqualTo(queryModel.getNeedStatus()); //查询状态等于指定值
        }

        if (queryModel.getHospitalId() != null) {
            sc.andHospitalIdEqualTo(queryModel.getHospitalId());
        }
        if(login.getLoginType()==3||login.getLoginType()==4){
        	sc.andNeedStatusNotEqualTo(1);//非草稿状态
        }

        int count = (int) hospitalNeedInfoMapper.countByExample(se);
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

        List<HospitalNeedInfo> list = hospitalNeedInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (HospitalNeedInfo model : list) {
            list2.add(getHospitalNeedInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装医院需求为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getHospitalNeedInfoModel(
        HospitalNeedInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hospitalNeedInfo", model);
        map.put("wzTypeStr",
            DataListUtils.getWzTypeNameById(model.getWzType() + "")); //解释物资类型字段

        if (model.getHospitalId() != null) {
            HospitalInfo hospitalInfo = hospitalInfoMapper.selectByPrimaryKey(model.getHospitalId()); //发布医院为外接字段,需要关联医院来解释该字段

            if (hospitalInfo != null) {
                map.put("hospitalIdStr", hospitalInfo.getHospitalName());
            }
        }

        map.put("needStatusStr",
            DataListUtils.getNeedStatusNameById(model.getNeedStatus() + "")); //解释状态字段

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        hospitalNeedInfoMapper.deleteByPrimaryKey(id);
    }
}

