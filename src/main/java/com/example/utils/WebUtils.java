package com.example.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Ghost1590
 * @create 2021-08-23-21:17
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean){

        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str, Integer defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
