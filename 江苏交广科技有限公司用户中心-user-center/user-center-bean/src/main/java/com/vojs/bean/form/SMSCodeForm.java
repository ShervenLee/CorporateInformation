package com.vojs.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by apple on 16/5/8.
 */
@ApiModel
public class SMSCodeForm extends BaseForm {

    @ApiModelProperty(value = "发送手机号码")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
