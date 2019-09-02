package com.vojs.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by apple on 16/4/24.
 */
@ApiModel
public class UserRegisterForm extends BaseForm {

    @ApiModelProperty(value = "用户编号", required = false)
    private String _id;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private int age;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String gender;


    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号码")
    private String idCard;

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
     * qq app id
     */
    @ApiModelProperty(value = "qq app id", required = false)
    private String qqAppId;

    @ApiModelProperty(value = "昵称")
    private String nickname;
    /**
     * qq登录openid
     */
    @ApiModelProperty(value = "qq open id", required = false)
    private String qqOpenId;

    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Integer id;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 加密后的密码
     */
    @ApiModelProperty(value = "加密后密码")
    private String hashedPassword;

    /**
     * 用户状态
     */
    @ApiModelProperty(value = "用户状态")
    private short status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "注册时间")
    private Long regTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    /**
     * 注册IP
     */
    @ApiModelProperty(value = "注册者IP")
    private String regIp;



    /**
     * 头像
     */
    @ApiModelProperty(value = "头像地址")
    private String portrait;


    /**
     * 地址
     */
    @ApiModelProperty(value = "用户地址")
    private String address;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }


    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Long getRegTime() {
        return regTime;
    }

    public void setRegTime(Long regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getWxPublicAccount() {
        return wxPublicAccount;
    }

    public void setWxPublicAccount(String wxPublicAccount) {
        this.wxPublicAccount = wxPublicAccount;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
