package com.vojs.bean;

/**
 * Created by chenyunjie on 2017/4/27.
 */
public enum ActivityTypeEnum {
    LOTTERY((short)1), //抽奖
    VOTE((short)2),    //投票
    SIGN_UP((short)3), //报名
    MALL((short)4);     //商城

    private short type;

    private ActivityTypeEnum(short value) {
        this.type = value;
    }

    public short getType() {
        return this.type;
    }
}
