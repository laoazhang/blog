package com.laoazhang.enums;

import io.swagger.annotations.ApiModel;
/**
 * @Author laoazhang
 * @CreateTime 2024/5/9 23:50
 * @Description: 返回结果集状态码
 * @Version 1.0
 */
@ApiModel("统一返回类型枚举类")
public enum ResultCodeEnum {
    SUCCESS(200, "默认成功"),
    ERROR(500, "默认失败"),
    BIZ_ERROR(500, "通用业务异常"),
    FILE_OUT_MAX(500, "文件超出最大限制"),
    FILE_FORMAT_ERROR(500, "文件格式不正确"),
    PARAM_ERROR(500, "参数错误"),
    JSON_FORMAT_ERROR(500, "Json解析异常"),
    SQL_ERROR(500, "Sql解析异常"),
    NETWORK_TIMEOUT(500, "网络超时"),
    UNKNOWN_INTERFACE(500, "未知的接口"),
    REQ_MODE_NOT_SUPPORTED(500, "请求方式不支持"),
    SYS_ERROR(500, "系统异常");

    private final Integer code;
    private final String msg;

    ResultCodeEnum(Integer code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }

}
