package com.vojs.bean.form;

import com.alibaba.fastjson.JSON;

/**
 * Created by chenyunjie on 2017/4/27.
 */
public class AddUserActivityContactForm  extends BaseForm  {

    /**
     * 用户编号
     */
    private String uuid;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动类型
     * 1：抽奖
     * 2：投票
     * 3：报名
     * 4：商城
     * 5：客户端 && LIVE
     */
    private short activityType;

    /**
     * 活动编号
     */
    private long activityCode;

    /**
     * 时间
     */
    private long datetime;

    /**
     * 联系信息内容
     */
    private String contact;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
