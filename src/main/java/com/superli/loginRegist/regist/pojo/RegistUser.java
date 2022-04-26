package com.superli.loginRegist.regist.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author superli
 * @since 2022-04-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("regist_user")
@ApiModel(value = "RegistUser对象", description = "")
public class RegistUser implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;
    @TableField( fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @TableField( fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别1:男0:女")
    private Integer sex;


}
