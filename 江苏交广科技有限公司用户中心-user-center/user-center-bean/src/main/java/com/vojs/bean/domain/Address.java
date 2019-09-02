package com.vojs.bean.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by chenyunjie on 2017/4/28.
 */
public class Address {

    /**
     * 地址编号
     */
    private long id;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系人号码
     */
    private String mobile;

    /**
     * 是否默认
     */
    private int isDefault;

    /**
     * 用户编号uuid
     */
    private String uuid;

    /**
     * 用户编号，长整型
     */
    private long userId;
    
    /**
     * 是否默认
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Integer getIsdefault() {
        return this.isDefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isDefault = isdefault;
    }

    public String toString() {

        return JSON.toJSONString(this);

    }
}
