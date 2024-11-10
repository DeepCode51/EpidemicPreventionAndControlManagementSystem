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
public class OrderInfoServiceImpl implements OrderInfoService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    HospitalNeedInfoMapper hospitalNeedInfoMapper;
    @Autowired
    CompanyInfoMapper companyInfoMapper;
    @Autowired
    HospitalInfoMapper hospitalInfoMapper;
    @Autowired
    CarInfoMapper carInfoMapper;

    /**
      认领需求
    */
    @Override
    public String add(OrderInfo model, LoginModel login) {
        model.setCompanyId(login.getId()); //登录id
        model.setOrderStatus(1); //默认已认领,
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        if(model.getPrice()==null){
        	return "请填入价格";
        }
        if(model.getNum()==null){
        	return "请填入提供数量";
        }

        HospitalNeedInfo hospitalNeedInfo = hospitalNeedInfoMapper.selectByPrimaryKey(model.getNeedId()); //查询医院需求供以下填入其他字段
        CarInfo carInfo = carInfoMapper.selectByPrimaryKey(model.getCarId()); //查询车辆供以下填入其他字段

        if (hospitalNeedInfo != null) {
            model.setWzName(hospitalNeedInfo.getWzName());
        }

        if (hospitalNeedInfo != null) {
            model.setHospitalId(hospitalNeedInfo.getHospitalId());
        }

        if (hospitalNeedInfo != null) {
            model.setHospitalAddress(hospitalNeedInfo.getAddress());
        }

        if (carInfo != null) {
            model.setCarType(carInfo.getCarType());
        }
        model.setTotalAmount(model.getPrice()*model.getNum());
        orderInfoMapper.insertSelective(model); //插入数据

        return "";
    }

    /**
      发货
    */
    @Override
    public String fh(OrderInfo model, LoginModel login) {
        OrderInfo preModel = orderInfoMapper.selectByPrimaryKey(model.getId());
        String check1 = checkData(model, 2); //检查数据是否合法

        if (check1.equals("") == false) {
            return check1;
        }

        preModel.setOrderStatus(3); //订单状态设置为已发货
        preModel.setCarId(model.getCarId());
        preModel.setContactName(model.getContactName());
        preModel.setContactCel(model.getContactCel());
        preModel.setOutTime(model.getOutTime());

        CarInfo carInfo = carInfoMapper.selectByPrimaryKey(model.getCarId()); //查询车辆供以下填入其他字段
        preModel.setCarType(carInfo.getCarType());
        orderInfoMapper.updateByPrimaryKey(preModel); //更新数据

        return "";
    }

    /**
    *根据参数查询厂商订单列表数据
    */
    @Override
    public Map<String, Object> getDataList(OrderInfo queryModel, Integer page,
        Integer pageSize, LoginModel login) {
        OrderInfoExample se = new OrderInfoExample();
        OrderInfoExample.Criteria sc = se.createCriteria();
        se.setOrderByClause("id desc"); //默认按照id倒序排序

        if (queryModel.getId() != null) {
            sc.andIdEqualTo(queryModel.getId());
        }

        if (queryModel.getNeedId() != null) {
            sc.andNeedIdEqualTo(queryModel.getNeedId());
        }

        if ((queryModel.getWzName() != null) &&
                (queryModel.getWzName().equals("") == false)) {
            sc.andWzNameLike("%" + queryModel.getWzName() + "%"); //模糊查询
        }

        if (queryModel.getOrderStatus() != null) {
            sc.andOrderStatusEqualTo(queryModel.getOrderStatus()); //查询订单状态等于指定值
        }

        if ((queryModel.getContactName() != null) &&
                (queryModel.getContactName().equals("") == false)) {
            sc.andContactNameLike("%" + queryModel.getContactName() + "%"); //模糊查询
        }

        if (queryModel.getHospitalId() != null) {
            sc.andHospitalIdEqualTo(queryModel.getHospitalId());
        }

        if (queryModel.getCompanyId() != null) {
            sc.andCompanyIdEqualTo(queryModel.getCompanyId());
        }

        int count = (int) orderInfoMapper.countByExample(se);
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

        List<OrderInfo> list = orderInfoMapper.selectByExample(se); //执行查询语句
        Map<String, Object> rs = new HashMap<String, Object>();
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();

        for (OrderInfo model : list) {
            list2.add(getOrderInfoModel(model, login));
        }

        rs.put("list", list2); //数据列表
        rs.put("count", count); //数据总数
        rs.put("totalPage", totalPage); //总页数

        return rs;
    }

    /**
      封装厂商订单为前台展示的数据形式
    */
    @Override
    public Map<String, Object> getOrderInfoModel(OrderInfo model,
        LoginModel login) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orderInfo", model);

        if (model.getNeedId() != null) {
            HospitalNeedInfo hospitalNeedInfo = hospitalNeedInfoMapper.selectByPrimaryKey(model.getNeedId()); //需求id为外接字段,需要关联医院需求来解释该字段

            if (hospitalNeedInfo != null) {
                map.put("needIdStr",
                    DataListUtils.getWzTypeNameById(hospitalNeedInfo.getWzType() +
                        ""));
            }
        }

        if (model.getCompanyId() != null) {
            CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(model.getCompanyId()); //厂商id为外接字段,需要关联厂商来解释该字段

            if (companyInfo != null) {
                map.put("companyIdStr", companyInfo.getCompanyName());
            }
        }

        if (model.getHospitalId() != null) {
            HospitalInfo hospitalInfo = hospitalInfoMapper.selectByPrimaryKey(model.getHospitalId()); //目的地医院为外接字段,需要关联医院来解释该字段

            if (hospitalInfo != null) {
                map.put("hospitalIdStr", hospitalInfo.getHospitalName());
            }
        }

        map.put("orderStatusStr",
            DataListUtils.getOrderStatusNameById(model.getOrderStatus() + "")); //解释订单状态字段

        if (model.getCarId() != null) {
            CarInfo carInfo = carInfoMapper.selectByPrimaryKey(model.getCarId()); //分配汽车为外接字段,需要关联车辆来解释该字段

            if (carInfo != null) {
                map.put("carIdStr", carInfo.getCarNo());
            }
        }

        return map;
    }

    public String checkData(OrderInfo model, Integer type) { //type=1 表示认领需求操作,type=2 表示发货操作,

        if (type == 2) {
            if (model.getContactCel() != null) {
                Pattern p = Pattern.compile(
                        "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
                Matcher m = p.matcher(model.getContactCel());

                if (m.matches() == false) {
                    return "请输入正确的联系人电话";
                }
            }
        }

        return "";
    }
}

