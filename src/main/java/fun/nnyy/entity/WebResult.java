package fun.nnyy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fun.nnyy.constants.HttpStateEnum;
import fun.nnyy.utils.JsonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(value = "统一响应对象")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class WebResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "响应状态", example = "可选值参照枚举类")
    private int state = HttpStateEnum.SUCCESS.getCode();
    @ApiModelProperty(value = "请求地址", example = "/login")
    private String request;
    @ApiModelProperty(value = "响应信息", example = "操作成功")
    private String message = "";
    @ApiModelProperty(value = "异常信息", example = "操作失败，username为空")
    private String errorMessage = "";
    @ApiModelProperty(value = "返回数据-主体数据", example = "如返回机构对象")
    private T data;
    @ApiModelProperty(value = "返回变量-可返回非主体数据", example = "如返回数据ID")
    private Map<String, Object> variables = new HashMap<String, Object>();
    @ApiModelProperty
    private Long total;
    @ApiModelProperty
    private String version;

    // 是否成功
    @JsonIgnore
    public boolean isSuccess(){
        return HttpStateEnum.SUCCESS.getCode() == state;
    }

    // 是否成功
    @JsonIgnore
    public boolean isFailed(){
        return HttpStateEnum.SUCCESS.getCode() != state;
    }

    /**
     * 添加响应变量
     * @param key	变量key
     * @param value 变量值
     */
    public void addVariable(String key, Object value) {
        this.variables.put(key, value);
    }

    /**
     * 获取变量key的值
     *
     * @param key	变量key
     * @return
     */
    public Object getVariable(String key) {
        if(variables == null){
            return null;
        }
        return variables.get(key);
    }

    // 返回成功
    public static WebResult success(){
        WebResult r = new WebResult();
        r.setState(HttpStateEnum.SUCCESS.getCode());
        r.setMessage(HttpStateEnum.SUCCESS.getMessage());
        return r;
    }
    // 返回失败
    public static WebResult error(){
        WebResult r = new WebResult();
        r.setState(HttpStateEnum.ERROR.getCode());
        r.setMessage(HttpStateEnum.ERROR.getMessage());
        return r;
    }
    // 返回认证失败
    public static WebResult authFailed(){
        WebResult r = new WebResult();
        r.setState(HttpStateEnum.NO_PERMISSION.getCode());
        r.setMessage(HttpStateEnum.NO_PERMISSION.getMessage());
        return r;
    }

    // 链式调用
    public WebResult state(int state){
        this.setState(state);
        return this;
    }
    public WebResult message(String message){
        this.setMessage(message);
        return this;
    }
    public WebResult version(String version){
        this.setVersion(version);
        return this;
    }
    public WebResult errorMessage(String errorMessage){
        this.setErrorMessage(errorMessage);
        return this;
    }
    public WebResult request(String request){
        this.setRequest(request);
        return this;
    }
    public WebResult<T> data(T data){
        this.setData(data);
        return this;
    }
    public WebResult<T> total(Long total){
        this.setTotal(total);
        return this;
    }
    public WebResult<T> total(Integer total){
        this.setTotal(Long.valueOf(total));
        return this;
    }

    public String toString() {
        return toJsonString();
    }
    public String toJsonString(){
        return JsonUtils.toJSONString(this);
    }
}