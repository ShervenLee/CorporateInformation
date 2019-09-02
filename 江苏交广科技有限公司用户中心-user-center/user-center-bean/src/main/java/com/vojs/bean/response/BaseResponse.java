package com.vojs.bean.response;

import com.vojs.bean.annotations.MapKey;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 所有接口返回基类
 *
 * Created by apple on 16/4/24.
 */
public class BaseResponse {

    /**
     * 响应是否成功
     */
    protected boolean success;

    /**
     * 错误信息
     */
    protected Object error;



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Map<String,Object> map() throws Exception {
        return object2Map();
    }

    protected Map<String,Object> object2Map() throws Exception {
        if(this == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();

            // 过滤class属性
            if (!key.equals("class")) {
                // 得到property对应的getter方法

                Field field = getClassField(this.getClass(), key);

                MapKey mapKey = field.getAnnotation(MapKey.class);

                if (mapKey != null && StringUtils.isNotBlank(mapKey.value())) {
                    key = mapKey.value();
                }

                Method getter = property.getReadMethod();
                Object value = getter.invoke(this);


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
