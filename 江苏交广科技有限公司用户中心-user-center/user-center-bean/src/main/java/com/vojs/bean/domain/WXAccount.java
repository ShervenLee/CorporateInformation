package com.vojs.bean.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by apple on 16/5/1.
 */
public class WXAccount {

    /**
     * 编号
     */
    @JSONField(serialize = false)
    private String id;

    /**
     * 微信开放平台id
     */
    private String wxUnionId;

    /**
     * 微信公众号openid
     */
    private String wxOpenId;

    /**
     * 微信账号
     */
    private String wxPublicAccount;

    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    private long cTime;

    /**
     * 更新时间
     */
    @JSONField(serialize = false)
    private long uTime;

    /**
     * 删除标记
     */
    @JSONField(serialize = false)
    private String deleteFlag;

    public WXAccount() {
    }

    public WXAccount(String wxUnionId, String wxOpenId, String wxPublicAccount) {
        this.wxUnionId = wxUnionId;
        this.wxOpenId = wxOpenId;
        this.wxPublicAccount = wxPublicAccount;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getcTime() {
        return cTime;
    }

    public void setcTime(long cTime) {
        this.cTime = cTime;
    }

    public long getuTime() {
        return uTime;
    }

    public void setuTime(long uTime) {
        this.uTime = uTime;
    }

    public boolean isNotEmpty() {
       return StringUtils.isNotBlank(wxUnionId) ||
                (StringUtils.isNotBlank(wxOpenId) && StringUtils.isNotBlank(wxPublicAccount));
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
