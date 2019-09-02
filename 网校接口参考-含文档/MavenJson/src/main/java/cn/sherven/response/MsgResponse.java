package cn.sherven.response;

/**
 * @classname MsaResponse
 * @Description 返回数据 Json格式的封装
 */
public class MsgResponse {
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_ERROR=0;

    //状态码, 成功1, 失败0
    private int code;

    //错误和成功信息
    private String msg;

    private Object data;

    public MsgResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public MsgResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    public MsgResponse(Object data) {
        this.code = CODE_SUCCESS;
        this.msg = null;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
