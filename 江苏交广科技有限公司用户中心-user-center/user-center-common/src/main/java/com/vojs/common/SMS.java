package com.vojs.common;

import com.vojs.common.cache.SMSCache;
import com.vojs.common.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by apple on 16/5/8.
 */
@Repository
public class SMS {

    private static String template = "您的动态密码是：%s，有效期15分钟【江苏广电】";

    @Autowired
    private SMSCache smsCache;
    /**
     * 发送短信
     *
     * @param mobileList
     * @param content
     * @return
     */
    private boolean send(String mobileList, String content) {

        String username = AppConstants.configProperties.getProperty("vojs.sms.username");
        String password = AppConstants.configProperties.getProperty("vojs.sms.password");

        String host = AppConstants.configProperties.getProperty("vojs.sms.host");
        String port = AppConstants.configProperties.getProperty("vojs.sms.port");

        HashMap<String,String> params = new HashMap<String, String>();

        params.put("username", username);
        params.put("password", password);
        params.put("productid", "6");
        params.put("longnum", "");
        params.put("msg", content);

        params.put("phonelist", mobileList);

        try {
            String response = HttpClientUtil.post("http://" + host + ":" + port + "/default.asmx/SendSms", params, "UTF-8");

            //JSONObject object = JSONObject.parseObject(response);

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 发送密码登录验证码
     *
     * @param mobile
     * @param code
     * @return
     */
    public boolean sendPasswordCode(String mobile, String code) {

        String content = String.format(template, code);

        String cachedCode = smsCache.passwordCode(mobile);

        if (StringUtils.isEmpty(cachedCode)) {
            return send(mobile, content);
        }

        return false;
    }

}
