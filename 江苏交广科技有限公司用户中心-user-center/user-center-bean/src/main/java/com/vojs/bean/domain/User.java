package com.vojs.bean.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by apple on 16/4/24.
 */
public class User implements Serializable {

    private String _id;

    private String uuid;
    /**
     * 用户编号
     */
    @JSONField(serialize = false)
    private Integer id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 登录密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 盐值
     */
    @JSONField(serialize = false)
    private String salt;
    /**
     * 加密后的密码
     */
    @JSONField(serialize = false)
    private String hashedPassword;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    private String regTime;

    @JSONField(serialize = false)
    private Long registerTime;

    /**
     * 更新时间
     */
    @JSONField(serialize = false)
    private Long updateTime;

    /**
     * 注册IP
     */
    @JSONField(serialize = false)
    private String regIp;

    /**
     * 客户端编号
     */
    private String clientAppId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 头像
     */
    private String portrait;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 地址
     */
    private String address;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 登录名
     */
    private String username;

    /**
     * 微信用户信息
     */
    private List<WXUnion> wxOpenUserList;

    /**
     * 主账号信息
     */
    @JSONField(serialize = false)
    private String parentId;

    private String wxUnionId;

    private String wxPublicAccount;

    private String wxOpenId;

    private String qqAppId;

    private String qqOpenId;

    @JSONField(serialize = false)
    private int skip = 0;

    @JSONField(serialize = false)
    private int limit = 10;

    /**
     * 删除标识
     * 0 正常, 1 已删除
     * */
    private String deleteFlag;

    /**
     * 用户身份
     * 1：普通用户
     * 2：主持人
     */
    private Integer identity;
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String _id) {
        this._id = _id;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }


    public String getClientAppId() {
        return clientAppId;
    }

    public void setClientAppId(String clientAppId) {
        this.clientAppId = clientAppId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }


    public String getGender() {
        if (StringUtils.isNotBlank(gender) ) {
            return gender;//.equals("男") ? "1" : "0";
        }
        return null;
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

    
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    
    public String getHashedPassword() {

        return hashedPassword;
    }

    
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    
    public Long getRegisterTime() {
        if (registerTime == null) {
            return new Date().getTime();
        }
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public List<WXUnion> getWxOpenUserList() {
        if (wxOpenUserList == null) {
            wxOpenUserList = new ArrayList<WXUnion>();
        }
        return wxOpenUserList;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

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

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getIdentity() {
        if (identity == null) {
            return 1;
        }
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public void doPasswordSaltMD5() {
        this.setHashedPassword(doPasswordSaltMD5(null));
    }

    public String doPasswordSaltMD5(String password) {

        if (password == null || password.equals("")) {
            password = this.password;
        }

        String saltString = this.salt == null ? RandomString(32) : this.salt;
        this.salt = saltString;
        try {
            String md5Value = md5(password);
            String saltValue = md5(md5Value.toUpperCase() + saltString);

            return  saltValue;
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) throws Exception {
        // 生成一个MD5加密计算摘要
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 计算md5函数
        md.update(str.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        return new BigInteger(1, md.digest()).toString(16);
    }


    public static String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*()?><_=+";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(str.length());
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }


}
