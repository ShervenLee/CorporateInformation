package com.vojs.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户登录Form
 *
 * Created by apple on 16/4/24.
 */
@ApiModel
public class UserLoginForm extends BaseForm {

    /**
     * 微信开放平台unionId
     */
    @ApiModelProperty(value = "微信开放平台unionId", required = false)
    private String wxUnionId;

    /**
     * 微信登录账号
     */
    @ApiModelProperty(value = "微信登录账号", required = false)
    private String wxPublicAccount;

    /**
     * 微信登录openid
     */
    @ApiModelProperty(value = "微信openId", required = false)
    private String wxOpenId;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "登录邮箱", required = false)
    private String email;

    /**
     * 登录用户名
     */
    @ApiModelProperty(value = "用户名", required = false)
    private String username;

    /**
     * 登录手机号
     */
    @ApiModelProperty(value = "手机号码", required = false)
    private String mobile;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "加密密码", required = false)
    private String password;

    /**
     * qq app id
     */
    @ApiModelProperty(value = "qq app id", required = false)
    private String qqAppId;

    /**
     * qq登录openid
     */
    @ApiModelProperty(value = "qq open id", required = false)
    private String qqOpenId;

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    public String getWxPublicAccount() {
        return wxPublicAccount;
    }

    public void setWxPublicAccount(String wxPublicAccount) {
        this.wxPublicAccount = wxPublicAccount;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQqAppId() {
        return qqAppId;
    }

    public void setQqAppId(String qqAppId) {
        this.qqAppId = qqAppId;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }
}
