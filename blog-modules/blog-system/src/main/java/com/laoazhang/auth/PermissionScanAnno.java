package com.laoazhang.auth;

import java.lang.annotation.*;

/**
 * @Author laoazhang
 * @CreateTime 2024/6/3 15:31
 * @Description: 权限注解
 * @Version 1.0
 */
// 注解在方法上，类上面生效
@Target({ElementType.METHOD, ElementType.TYPE})
// 注解可以通过反射获取
@Retention(RetentionPolicy.RUNTIME)
// 可以被javadoc工具，提取为文档
@Documented
// 可以被继承
@Inherited
public @interface PermissionScanAnno {

    // 注解的第一个值：Permission的sn字段值
    String sn();

    // 注解的第二个值：Permission的name字段值
    String name();
}
