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
public class ActInfoServiceImpl implements ActInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    ActInfoMapper actInfoMapper;

    /**
      新增
    */
    @Override
    public String add(ActInfo model, LoginModel login) {
        String check = checkData(model, 1); //检查数据是否符合要求

        if (check.equals("") == false) {
            return check;
        }

        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        actInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      修改
    */
    @Override
    public String update(ActInfo model, LoginModel login) {
        ActInfo preModel = actInfoMapper.selectByPrimaryKey(model.getId());
        String check1 = checkData(model, 2); //检查数据是否合法

        if (check1.equals("") == false) {
            return check1;
        }

        preModel.setActImg(model.getActImg());
        preModel.setActTitle(model.getActTitle());
        preModel.setActContent(model.getActContent());
        actInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询活动列表数据
    */
    @Override
    public Map<String, Object> getDataList(ActInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        ActInfoExample se = new ActInfoExample();
        ActInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if ((queryModel.getActTitle() != null) &&
                (queryModel.getActTitle().equals("") == false)) {
            sc.andActTitleLike("%" + queryModel.getActTitle() + "%"); //模糊查询
        }

        int count = (int) actInfoMapper.countByExample(se);
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

        List<ActInfo> list = actInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (ActInfo model : list) {
            list2.add(getActInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装活动为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getActInfoModel(ActInfo model, LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("actInfo", model);

        return map;
    }

    /**
    * 删除数据
    */
    @Override
    public void delete(Integer id) {
        actInfoMapper.deleteByPrimaryKey(id);
    }

    public String checkData(ActInfo model, Integer type) { //type=1 表示新增操作,type=2 表示修改操作,

        if ((type == 1) || (type == 2)) {
            if (model.getActImg() != null) {
                String[] fileSplit = model.getActImg().split(";");

                if (fileSplit.length > 1) {
                    return "活动大图的图片数量不能大于1";
                }
            }
        }

        return "";
    }
}

