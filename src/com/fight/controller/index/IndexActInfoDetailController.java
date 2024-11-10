package com.fight.controller.index;

import com.fight.controller.*;

import com.fight.dao.*;

import com.fight.model.*;

import com.fight.service.*;

import com.fight.util.*;
import com.fight.util.PageUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/commonapi/index/act_info/detail")
public class IndexActInfoDetailController {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ActInfoMapper actInfoMapper;

    /**
            进入搜索列表接口
    **/
    @RequestMapping(value = "")
    public String index(ModelMap modelMap, Integer id,
        HttpServletRequest request) {
        LoginModel login = (LoginModel) request.getSession()
                                               .getAttribute(CommonVal.sessionName);
        modelMap.addAttribute("login", login);

        ActInfo t = actInfoMapper.selectByPrimaryKey(id);

        if (t == null) {
            t = new ActInfo();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("t", t);
        modelMap.addAttribute("detail", map);

        return "index/act_info_detail";
    }
}

