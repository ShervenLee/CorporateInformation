package com.vojs.bean.response;

/**
 * Created by chenyunjie on 2017/5/8.
 */
public class DataResponse extends BaseResponse {

    /**
     * 数据
     */
    public Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
