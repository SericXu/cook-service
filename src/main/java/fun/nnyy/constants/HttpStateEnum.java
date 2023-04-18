package fun.nnyy.constants;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HttpStateEnum {
    SUCCESS(200, "请求成功"),NO_PERMISSION(401, "未授权"),ERROR(500, "请求失败"),PARAM_ERROR(400, "参数异常");

    private int code;
    private String message;

    private HttpStateEnum(int code){
        this.code = code;
        this.message = "";
    }

    private HttpStateEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}