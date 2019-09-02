package com.vojs.common.cache;

import com.vojs.common.MemcacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by apple on 16/5/13.
 */
@Repository
public class UserCache {

    @Autowired
    private MemcacheManager memcacheManager;




    private Object get(Object o, String fieldName) throws Exception {
        Field field = o.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Object value = ReflectionUtils.getField(field, o);
        return value;
    }

}
