package com.laoazhang.enums;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/9 23:50
 * @Description: 返回结果集状态码
 * @Version 1.0
 */
public enum Constants {
    //请求成功
    SUCCESS(200),

    //请求失败
    FAIL(400),

    //未认证（签名错误）
    UNAUTHORIZED(401),

    //资源拒绝访问
    FORBIDDEN(403),

    //接口不存在
    NOT_FOUND(404),

    //服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    Constants(int code) {
        this.code = code;
    }
}
