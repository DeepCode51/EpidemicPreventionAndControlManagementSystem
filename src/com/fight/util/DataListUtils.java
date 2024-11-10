package com.fight.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 下拉列表常用数据解释器
 * @author Administrator
 *
 */
public class DataListUtils {
    public static void main(String[] args) {
    }

    /**
    **获取登录角色列表
    */
    public static List<Map<String, Object>> getLoginTypeList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "admin"));
        list.add(getMap("2", "hospital"));
        list.add(getMap("3", "company"));
        list.add(getMap("4", "volunteer"));

        return list;
    }

    /**
    **获取wz_type数据列表
    */
    public static List<Map<String, Object>> getWzTypeList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "安心裤"));
        list.add(getMap("2", "卫生巾"));
        list.add(getMap("3", "护手霜"));
        list.add(getMap("4", "其他"));

        return list;
    }

    public static String getWzTypeNameById(String id) { //根据wz_type的key值获取名称

        List<Map<String, Object>> list = getWzTypeList();

        return getNameById(id, list);
    }

    /**
    **获取need_status数据列表
    */
    public static List<Map<String, Object>> getNeedStatusList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "草稿"));
        list.add(getMap("2", "已发布"));
        list.add(getMap("3",
                "已完成需求"));

        return list;
    }

    public static String getNeedStatusNameById(String id) { //根据need_status的key值获取名称

        List<Map<String, Object>> list = getNeedStatusList();

        return getNameById(id, list);
    }

    /**
    **获取order_status数据列表
    */
    public static List<Map<String, Object>> getOrderStatusList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(getMap("1", "已认领"));
        list.add(getMap("2",
                "已同意认领"));
        list.add(getMap("3", "已发货"));
        list.add(getMap("4",
                "已确认收货"));
        list.add(getMap("5",
                "已拒绝认领"));

        return list;
    }

    public static String getOrderStatusNameById(String id) { //根据order_status的key值获取名称

        List<Map<String, Object>> list = getOrderStatusList();

        return getNameById(id, list);
    }

    public static String getNameById(String id, List<Map<String, Object>> list) {
        if (id == null) {
            return null;
        }

        if (id.endsWith(",")) {
            id = id.substring(0, id.length() - 1);
        }

        String[] idsplit = id.split(",");
        String rs = "";

        for (String tmp : idsplit) {
            for (Map<String, Object> map : list) {
                if (map.get("id").toString().equals(tmp)) {
                    rs += (map.get("name").toString() + ",");
                }
            }
        }

        if (rs.endsWith(",")) {
            rs = rs.substring(0, rs.length() - 1);
        }

        return rs;
    }

    private static Map<String, Object> getMap(String id, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);

        return map;
    }
}

