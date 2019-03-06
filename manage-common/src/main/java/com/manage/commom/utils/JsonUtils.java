package com.manage.commom.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);


    /**
     * json转Obj。
     *
     * @param str
     * @return
     */
    public static Object jsonToObj(String str, Class clazz) {
        return JSON.parseObject(str, clazz);
    }
    /**
     * Obj转json。
     *
     * @param object
     * @return
     */
    public static String objToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * str 转为 list
     * @param str
     * @param clazz
     * @return
     */
    public static List jsonToList(String str, Class clazz) {
        return JSONArray.parseArray(str,clazz);
    }


    /**
     * 将json转为map
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> parseJSON2MapByStep(String jsonStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            map.put(k.toString(), v);
        }
        return map;
    }

    /**
     * 将json转为map
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> parseJSON2Map(String jsonStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            //如果内层还是数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = (JSONObject) it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v.toString());
            }
        }
        return map;
    }


    /**
     * 将传入的字符串首字母大写
     *
     * @param name
     * @return
     */
    public static String getBigStr(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }


    /**
     * 校验必填数据。
     *
     * @param args 必填数据
     * @return true:满足,false:不满足.
     */
    public static boolean checkData(Object... args) {
        for (Object param : args) {
            if (param == null) {
                return false;
            }
            if (param instanceof Integer) {
                int value = (Integer) param;
                if (value <= 0) {
                    return false;
                }
                continue;
            } else if (param instanceof BigDecimal) {
                BigDecimal b = (BigDecimal) param;
                if (b.compareTo(BigDecimal.ZERO) <= 0) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }

    /**
     * map转对象
     *
     * @param map
     * @param clazz
     * @return
     * map2Bean(parseJSON2MapByStep(decrypText).get("resultSets").get("resultSets"),BatchTranferTradeByCustInput b)
     */
    public static Object map2Bean(Map<String, Object> map, Class clazz) {
        try {
            Object o = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Method srcMethod = clazz.getDeclaredMethod("set" + getBigStr(f.getName()), f.getType());
                srcMethod.invoke(o, map.get(f.getName()));
            }
            return o;
        } catch (Exception ex) {
            LOGGER.error("map转对象异常:" ,ex);
        }
        return null;
    }

    /**
     * map转对象
     *
     * @param map
     * @param clazz
     * @return
     * map2Bean(parseJSON2MapByStep(decrypText).get("resultSets").get("resultSets"),BatchTranferTradeByCustInput b)
     */
    public static Object mapToBean(Map<String, String> map, Class clazz) {
        try {
            Object o = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Method srcMethod = clazz.getDeclaredMethod("set" + getBigStr(f.getName()), f.getType());
                srcMethod.invoke(o, map.get(f.getName()));
            }
            return o;
        } catch (Exception ex) {
            LOGGER.error("map转对象异常:" ,ex);
        }
        return null;
    }

    public static String spaceConversion(Object o) {
        return "null".equals(String.valueOf(o)) ? "" : String.valueOf(o);
    }


    public static String checkBigDecimal(Object object) {
        if(object != null){
            return String.valueOf(object);
        }
        return null;
    }

}
