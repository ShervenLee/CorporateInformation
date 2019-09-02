package com.vojs.common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyunjie on 2017/5/2.
 */
public class BeanUtils {

    public static Map<String,Object> map(Object o) throws Exception {
        return object2Map(o);
    }

    protected static Map<String,Object> object2Map(Object o) throws Exception {
        if(o == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();

            // 过滤class属性
            if (!key.equals("class")) {
                // 得到property对应的getter方法

                Field field = getClassField(o.getClass(), key);

                Method getter = property.getReadMethod();
                Object value = getter.invoke(o);


                map.put(key, value);
            }

        }
        return map;
    }

    /**
     * 这个方法，是最重要的，关键的实现在这里面
     *
     * @param aClazz
     * @param aFieldName
     * @return
     */
    private static Field getClassField(Class aClazz, String aFieldName) {
        Field[] declaredFields = aClazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 注意：这里判断的方式，是用字符串的比较。很傻瓜，但能跑。要直接返回Field。我试验中，尝试返回Class，然后用getDeclaredField(String fieldName)，但是，失败了
            if (field.getName().equals(aFieldName)) {
                return field;// define in this class
            }
        }

        Class superclass = aClazz.getSuperclass();
        if (superclass != null) {// 简单的递归一下
            return getClassField(superclass, aFieldName);
        }
        return null;
    }
}
