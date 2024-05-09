package com.laoazhang.user.domain;

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
public class User {

    // 用户id
    private String id;
    // 用户名
    private String userName;
    // 真实姓名
    private String realName;
    // 邮箱
    private String email;
    // 头像地址
    private String avatar;
    // 密码
    private String password;
    // 备注
    private String remark;
    // 手机号码
    private String phone;
    // 登录信息id
    private Long logininfoId;
}
