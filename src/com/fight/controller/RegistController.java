package com.fight.controller;

import com.fight.controller.LoginModel;

import com.fight.dao.*;

import com.fight.model.*;

import com.fight.util.*;
import com.fight.util.CommonVal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/commonapi")
public class RegistController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
    @Autowired
    VolunteerInfoMapper volunteerInfoMapper;

    /**
      系统进入注册页面接口
    */
    @RequestMapping(value = "volunteer_info_regist")
    public String volunteer_info_regist(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);

        return "volunteer_info_regist";
    }

    /**
      提交系统注册信息接口
    */
    @RequestMapping("volunteerInfoRegistSubmit")
    @ResponseBody
    public Object volunteerInfoRegistSubmit(String imgCode, String name,
        String password, String volunteerName, String volunteerCel,
        ModelMap modelMap, HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> rs = new HashMap<String, Object>();
        HttpSession session = request.getSession();

        if ((imgCode != null) &&
                !imgCode.toLowerCase()
                            .equals(request.getSession()
                                               .getAttribute(CommonVal.code)
                                               .toString().toLowerCase())) {
            rs.put("code", 0);
            rs.put("msg",
                "图片验证码错误");

            return rs;
        }

        if (name != null) {
            VolunteerInfoExample te = new VolunteerInfoExample();
            VolunteerInfoExample.Criteria tc = te.createCriteria();
            tc.andNameEqualTo(name);

            int count = (int) volunteerInfoMapper.countByExample(te);

            if (count > 0) {
                rs.put("code", 0);
                rs.put("msg",
                    "该账号已被注册,请用该账号登录");

                return rs;
            }
        }

        if ((volunteerCel != null) &&
                (volunteerCel.trim().equals("") == false)) {
            Pattern p = Pattern.compile(
                    "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
            Matcher m = p.matcher(volunteerCel);

            if (m.matches() == false) {
                ;
                rs.put("code", 0);
                rs.put("msg",
                    "请填入正确的联系号码");

                return rs;
            }
        }

        VolunteerInfo model = new VolunteerInfo();
        model.setName(name);
        model.setPassWord(password);
        model.setCreateTime(sdf1.format(new Date())); //当前时间格式
        model.setVolunteerName(volunteerName);
        model.setVolunteerCel(volunteerCel);
        volunteerInfoMapper.insertSelective(model); //注册成功,插入该账号进数据库,并返回提示
        rs.put("code", 1);
        rs.put("msg",
            "注册成功,请使用该账号密码登录");

        return rs;
    }
}

