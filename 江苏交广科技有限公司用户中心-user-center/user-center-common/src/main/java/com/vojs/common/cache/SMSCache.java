package com.vojs.common.cache;

import com.vojs.common.MemcacheManager;
import com.vojs.common.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * 保存短信发送相关
 *
 * Created by apple on 16/5/8.
 */
@Repository
public class SMSCache {

    private static final String PASSWORD_CODE_CACHE = "mobile_sms_code_";

    @Autowired
    private MemcacheManager memcacheManager;

    /**
     * 缓存短信验证码
     *
     * @param code
     * @param mobile
     */
    public void cachePasswordCode(String code, String mobile) {

        String expiryTime = AppConstants.configProperties.getProperty("vojs.sms.code.expiryTime");

        if (StringUtils.isEmpty(expiryTime)) {
            memcacheManager.set(PASSWORD_CODE_CACHE + mobile, AppConstants.MINUTE * 5,code);
        } else {
            memcacheManager.set(PASSWORD_CODE_CACHE + mobile, Integer.valueOf(expiryTime),code);
        }
    }

    /**
     * 获取短信密码
     *
     * @param mobile
     *      发送目标手机号码
     * @return
     */
    public String passwordCode(String mobile) {
        return memcacheManager.get(PASSWORD_CODE_CACHE + mobile);
    }

}
