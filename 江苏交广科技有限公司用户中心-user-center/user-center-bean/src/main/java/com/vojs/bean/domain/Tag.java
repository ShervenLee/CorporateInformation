package com.vojs.bean.domain;

import com.alibaba.fastjson.JSON;

/**
 * Created by chenyunjie on 2017/4/28.
 */
public class Tag {

    private long id;

    /**
     * 用户编号
     */
    private String uuid;

    /**
     * 标签内容
     */
    private String tagContent;

    /**
     * tag建立时间
     */
    private long tagTime;

    /**
     * 活动类型
     * 1：抽奖
     * 2：投票
     * 3：包名
     * 4：商城
     */
    private short activityType;

    /**
     * 活动编号
     */
    private long activityCode;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    public long getTagTime() {
        return tagTime;
    }

    public void setTagTime(long tagTime) {
        this.tagTime = tagTime;
    }

    public short getActivityType() {
        return activityType;
    }

    public void setActivityType(short activityType) {
        this.activityType = activityType;
    }

    public long getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(long activityCode) {
        this.activityCode = activityCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString() {

        return JSON.toJSONString(this);

    }
}
