package com.fight.controller.volunteer;

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
@RequestMapping("/volunteer/hospital_need_info")
public class VHospitalNeedInfoController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    HospitalNeedInfoService hospitalNeedInfoService;
    @Autowired
    HospitalNeedInfoMapper hospitalNeedInfoMapper;
    @Autowired
    VolunteerInfoMapper volunteerInfoMapper;

    public void getList(ModelMap modelMap, LoginModel login) { //获取数据列表并返回给前台
        modelMap.addAttribute("wzTypeList", DataListUtils.getWzTypeList()); //返回wz_type数据列表
        modelMap.addAttribute("needStatusList",
            DataListUtils.getNeedStatusList()); //返回need_status数据列表
    }

    /**
     * 返回医院需求列表jsp页面
    */
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName); //获取当前登录账号信息
        VolunteerInfo volunteerInfo = volunteerInfoMapper.selectByPrimaryKey(login.getId());
        modelMap.addAttribute("user", volunteerInfo);
        getList(modelMap, login); //获取数据列表并返回给前台

        return "volunteer/hospital_need_info/list";
    }

    /**
     * 根据查询条件分页查询医院需求数据,然后返回给前台渲染
    */
    @RequestMapping(value = "queryList")
    @ResponseBody
    public Object toList(HospitalNeedInfo model, Integer page,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);

        return hospitalNeedInfoService.getDataList(model, page,
            CommonVal.pageSize, login); //分页查询数据
    }
}

