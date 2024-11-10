package com.fight.controller.hospital;

import com.fight.controller.LoginModel;

import com.fight.dao.*;

import com.fight.model.*;

import com.fight.service.*;
import com.fight.service.impl.*;

import com.fight.util.*;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/hospital/order_info")
public class HOrderInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    OrderInfoService orderInfoService;
    @Autowired
    HospitalNeedInfoMapper hospitalNeedInfoMapper;
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    CarInfoMapper carInfoMapper;
    @Autowired
    HospitalInfoMapper hospitalInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        HospitalNeedInfoExample hospitalNeedInfoE = new HospitalNeedInfoExample();
        HospitalNeedInfoExample.Criteria hospitalNeedInfoC = hospitalNeedInfoE.createCriteria();
        hospitalNeedInfoC.andHospitalIdEqualTo(login.getId()); //发布医院等于当前登录id

        List<HospitalNeedInfo> hospitalNeedInfoList = hospitalNeedInfoMapper.selectByExample(hospitalNeedInfoE);
        List<Map<String, Object>> hospitalNeedInfoList2 = new ArrayList<Map<String, Object>>();

        for (HospitalNeedInfo m : hospitalNeedInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getWzType());
            hospitalNeedInfoList2.add(map);
        }

        modelMap.addAttribute("hospitalNeedInfoList", hospitalNeedInfoList2);

        HospitalInfoExample hospitalInfoE = new HospitalInfoExample();
        HospitalInfoExample.Criteria hospitalInfoC = hospitalInfoE.createCriteria();
        hospitalInfoC.andIdEqualTo(login.getId()); //ID等于当前登录id

        List<HospitalInfo> hospitalInfoList = hospitalInfoMapper.selectByExample(hospitalInfoE);
        List<Map<String, Object>> hospitalInfoList2 = new ArrayList<Map<String, Object>>();

        for (HospitalInfo m : hospitalInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getHospitalName());
            hospitalInfoList2.add(map);
        }

        modelMap.addAttribute("hospitalInfoList", hospitalInfoList2);
        modelMap.addAttribute("orderStatusList",
            DataListUtils.getOrderStatusList()); //返回order_status数据列表

        CarInfoExample carInfoE = new CarInfoExample();
        CarInfoExample.Criteria carInfoC = carInfoE.createCriteria();
        List<CarInfo> carInfoList = carInfoMapper.selectByExample(carInfoE);
        List<Map<String, Object>> carInfoList2 = new ArrayList<Map<String, Object>>();

        for (CarInfo m : carInfoList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", m.getId());
            map.put("name", m.getCarNo());
            carInfoList2.add(map);
        }

        modelMap.addAttribute("carInfoList", carInfoList2);
    }

    /**
     * 返回厂商订单列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        HospitalInfo hospitalInfo = hospitalInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", hospitalInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "hospital/order_info/list";
    }

    /**
     * 根据查询条件分页查询厂商订单数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(OrderInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        model.setHospitalId(login.getId()); //目的地医院等于当前登录id

        return orderInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //分页查询数据
    }

    /**
     * 接受订单,拒绝订单,确认收货,操作
    */
    @RequestMapping(value = "updateByDefault")
    @ResponseBody
    public Object updateByDefault(Integer id, Integer type, ModelMap modelMap,
        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        OrderInfo model = orderInfoMapper.selectByPrimaryKey(id);

        if (type == 1) { //type=1表示接受订单操作
            model.setOrderStatus(2);
            orderInfoMapper.updateByPrimaryKey(model);
        }

        if (type == 2) { //type=2表示拒绝订单操作
            model.setOrderStatus(5);
            orderInfoMapper.updateByPrimaryKey(model);
        }

        if (type == 3) { //type=3表示确认收货操作
            model.setOrderStatus(4);
            model.setQrTime(sdf2.format(new Date()));
            orderInfoMapper.updateByPrimaryKey(model);
            HospitalNeedInfo need = hospitalNeedInfoMapper.selectByPrimaryKey(model.getNeedId());
            need.setCompleteNum(need.getCompleteNum()+model.getNum());
            if(need.getCompleteNum()>=need.getWzNum()){
            	need.setNeedStatus(3);
            }
            hospitalNeedInfoMapper.updateByPrimaryKeySelective(need);
            
        }

        rs.put("code", 1);
        rs.put("msg",
            "操作成功");

        return rs;
    }
}

