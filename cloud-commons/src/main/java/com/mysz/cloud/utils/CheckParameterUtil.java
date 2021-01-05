package com.mysz.cloud.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: CheckParameterUtil
 * @Data: 2020/12/23 9:35
 **/
@Slf4j
public class CheckParameterUtil<T> {
    private static final String TYPE_BIG_DECIMAL = "BigDecimal";
    private static final String TYPE_INTEGER = "Integer";
    private static final String TYPE_INT = "int";
    private static final String TYPE_LONG = "Long";
    private static final String TYPE_L = "long";
    private static final String TYPE_DATE = "Date";
    private static final String TYPE_STRING = "String";
    private static final String TYPE_LIST = "List";

    public CheckParameterUtil() {
    }

    public Map<String, String> check4Object(T t) throws Exception {
        Map<String, String> data = new HashMap();
        try {
            Class<T> comClass= (Class<T>) t.getClass();
            for(Field field:comClass.getDeclaredFields()){
                if(null==field){
                    return  new HashMap<>();
                }
                field.setAccessible(true);
                Object o=field.get(t);
                log.info("对象属性：{}",o);
                if(o==null){
                    return new HashMap<>();
                }
                data.put(field.getName(),o.toString());
            }
        }catch (Exception e){

        }
        return data;
    }
}
