package com.vojs.bean.form;


import java.math.BigDecimal;
import java.util.Date;

public class AddTradeForm extends BaseForm {

    /**
     * 用户编号
     */
    private String uuid;

    /**
     * 微信的openid
     */
    private String openid;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别： 0：女  1：男
     */
    private Integer sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 开放平台uionId
     */
    private String unionId;

    /**
     * 微信账号
     */
    private String weixinAccount;

    /**
     * 支付渠道：目前仅支持微信 1： 微信
     */
    private Integer payChannel;

    /**
     * 收款公众号id
     */
    private String wxPublicId;

    /**
     * 商户订单号
     */
    private String merchantTradeId;

    /**
     * 第三方机构订单号
     */
    private String thirdPartyTradeId;

    /**
     * 支付时间
     */
    private Long payTime;

    /**
     * 支付金额
     */
    private BigDecimal payMoney;

    private String wxTradeId;

    /**
     * 支付目标商品的名称
     */
    private String payContent;

    /**
     * 支付状态：1：成功
     */
    private Integer tradeState;

    /**
     * 订单来源
     *
     * 1：大蓝鲸商城 2：公益 3：夺宝 4：报名
     */
    private Integer tradeSource;

    /**
     * 创建时间，接口不需要传递
     */
    private Long addTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }


    public String getMerchantTradeId() {
        return merchantTradeId;
    }

    public void setMerchantTradeId(String merchantTradeId) {
        this.merchantTradeId = merchantTradeId;
    }

    public String getThirdPartyTradeId() {
        return thirdPartyTradeId;
    }

    public void setThirdPartyTradeId(String thirdPartyTradeId) {
        this.thirdPartyTradeId = thirdPartyTradeId;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayContent() {
        return payContent;
    }

    public void setPayContent(String payContent) {
        this.payContent = payContent;
    }

    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
    }

    public Integer getTradeSource() {
        return tradeSource;
    }

    public void setTradeSource(Integer tradeSource) {
        this.tradeSource = tradeSource;
    }

    public String getWxPublicId() {
        return wxPublicId;
    }

    public void setWxPublicId(String wxPublicId) {
        this.wxPublicId = wxPublicId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount;
    }

    public Long getAddTime() {
        return new Date().getTime();
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getWxTradeId() {
        return wxTradeId;
    }

    public void setWxTradeId(String wxTradeId) {
        this.wxTradeId = wxTradeId;
    }
}
