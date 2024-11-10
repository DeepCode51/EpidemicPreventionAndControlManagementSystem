package com.fight.controller.company;

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
@RequestMapping("/company/order_info")
public class COrderInfoController {
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
    @Autowired
    CompanyInfoMapper companyInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台

        HospitalNeedInfoExample hospitalNeedInfoE = new HospitalNeedInfoExample();
        HospitalNeedInfoExample.Criteria hospitalNeedInfoC = hospitalNeedInfoE.createCriteria();
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
        carInfoC.andCompanyIdEqualTo(login.getId()); //厂商等于当前登录id

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
    public String index(ModelMap modelMap, Integer needId,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", companyInfo);

        OrderInfo model = new OrderInfo();
        model.setNeedId(needId);
        modelMap.addAttribute("data", model);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "company/order_info/list";
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
        model.setCompanyId(login.getId()); //厂商id等于当前登录id

        return orderInfoService.getDataList(model, page, CommonVal.pageSize,
            login); //分页查询数据
    }

    /**
     进入认领需求页面
    */
    @RequestMapping("add")
    public String add(ModelMap modelMap, OrderInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台
        modelMap.addAttribute("data", model);

        return "company/order_info/add_page";
    }

    /**
     认领需求提交信息接口
    */
    @RequestMapping("add_submit")
    @ResponseBody
    public Object add_submit(OrderInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = orderInfoService.add(model, login); //执行添加操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "认领成功，等待审核");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }

    /**
     进入发货页面
    */
    @RequestMapping("fh")
    public String fh(ModelMap modelMap, OrderInfo model,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //从session中获取当前登录账号	
        getList(modelMap, login); //获取前台需要用到的数据列表并返回给前台

        OrderInfo data = orderInfoMapper.selectByPrimaryKey(model.getId());
        modelMap.addAttribute("data", data);

        return "company/order_info/fh_page";
    }

    /**
     发货提交信息接口
    */
    @RequestMapping("fh_submit")
    @ResponseBody
    public Object fh_submit(OrderInfo model, ModelMap modelMap,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        Map<String, Object> rs = new HashMap<String, Object>();
        String msg = orderInfoService.fh(model, login); //执行修改操作

        if (msg.equals("")) {
            rs.put("code", 1);
            rs.put("msg",
                "修改成功");

            return rs;
        }

        rs.put("code", 0);
        rs.put("msg", msg);

        return rs;
    }
}

