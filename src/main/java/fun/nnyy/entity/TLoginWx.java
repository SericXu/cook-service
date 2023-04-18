package fun.nnyy.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import fun.nnyy.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author seric
 * @since 2023-04-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="TLoginWx对象", description="")
@TableName("t_login_wx")
public class TLoginWx extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "微信会话session_key")
    private String sessionKey;

    @ApiModelProperty(value = "微信openid")
    private String openid;

    @ApiModelProperty(value = "登录认证令牌")
    private String accessToken;

    @ApiModelProperty(value = "token有效期")
    private LocalDateTime expireTime;


}
