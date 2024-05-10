package com.laoazhang.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 14:37
 * @Description:
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty(value = "用户编号")
    private String id;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "用户姓名")
    private String realName;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "头像地址")
    private String avatar;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "登录信息id")
    private Long logininfoId;

}
