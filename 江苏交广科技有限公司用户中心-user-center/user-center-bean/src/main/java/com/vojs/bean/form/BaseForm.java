package com.vojs.bean.form;

import com.alibaba.fastjson.JSON;
import com.vojs.bean.UcUser;
import com.vojs.bean.exception.VOJSException;
import com.vojs.common.constants.AppConstants;
import com.vojs.ucenter.client.util.Authcode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

/**
 * 所有接口请求参数基类
 *
 * Created by apple on 16/4/24.
 */
@ApiModel
public class BaseForm implements Serializable {

    /**
     * app来源
     */
    @ApiModelProperty(value = "app名称", required = true)
    private String appname;

    /**
     * 加密后数据
     */
    @ApiModelProperty(value = "加密数据", required = false)
    private String appcode;

    /**
     * 客户端编号
     */
    @ApiModelProperty(value = "客户端编号")
    private String clientAppId;

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }


    public String getClientAppId() {
        return clientAppId;
    }

    public void setClientAppId(String clientAppId) {
        this.clientAppId = clientAppId;
    }

    public void decode() throws Exception, VOJSException {

        try {
            String key = AppConstants.configProperties.getProperty("source." + appname + ".key");
            String stringJSONValue = Authcode.authcodeDecode(appcode, key);
            stringJSONValue = URLDecoder.decode(stringJSONValue, "UTF-8");
            BaseForm object = JSON.parseObject(stringJSONValue, this.getClass());
            object.appname = appname;
            object.appcode = appcode;
            BeanUtils.copyProperties(this, object);
            this.clientAppId = AppConstants.configProperties.getProperty("source." + appname + ".value");
        } catch (Exception e) {
            throw new VOJSException("信息解密出错");
        }

    }

    public String toString() {

        return JSON.toJSONString(this);

    }
}
