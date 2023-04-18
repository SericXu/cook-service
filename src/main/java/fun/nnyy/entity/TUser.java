package fun.nnyy.entity;

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
@ApiModel(value="TUser对象", description="")
@TableName("t_user")
public class TUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "性别")
    private Boolean gender;

    @ApiModelProperty(value = "电话")
    private String phone;


}
