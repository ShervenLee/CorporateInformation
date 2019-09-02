package com.vojs.bean.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2016/11/2.
 */
public class WXUnion {

    @JSONField(serialize = false)
    private String id;

    private String userId;

    private String unionId;

    private List<WXAccount> wxAccounts;

    @JSONField(serialize = false)
    private String deleteFlag;

    public WXUnion(String userId) {
        this.userId = userId;
    }

    public WXUnion() {
    }

    public WXUnion(String deleteFlag, String userId) {
        this.deleteFlag = deleteFlag;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUnionId() {
        return unionId;
    }

    public List<WXAccount> getWxAccounts() {
        if (wxAccounts == null) {
            wxAccounts = new ArrayList<WXAccount>();
        }
        return wxAccounts;
    }

    public void setWxAccounts(List<WXAccount> wxAccounts) {
        this.wxAccounts = wxAccounts;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public void addWXAccount(WXAccount wxAccount) {
        if (wxAccounts == null) {
            wxAccounts = new ArrayList<WXAccount>();
        }
        wxAccounts.add(wxAccount);
    }

    public void addWXAccount(List<WXAccount> wxAccountList) {
        if (wxAccounts == null) {
            wxAccounts = new ArrayList<WXAccount>();
        }
        wxAccounts.addAll(wxAccountList);
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
