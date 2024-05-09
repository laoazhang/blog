package com.laoazhang.utils;

import com.laoazhang.enums.Constants;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 16:56
 * @Description: 统一返回结果集
 * @Version 1.0
 */
public class Result<T> {
    // 响应状态码
    private Integer code;

    // 操作结果
    private Boolean success;

    // 提示语
    private String msg;

    // 响应数据
    private T data;

    public static <T> Result<T> ok() {
        return new Result<T>(Constants.SUCCESS.code, true, "操作成功", null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(Constants.SUCCESS.code, true, "操作成功", data);
    }

    public static <T> Result<T> ok(String message) {
        return new Result<T>(Constants.SUCCESS.code, true, message, null);
    }

    public static <T> Result<T> ok(String message, T data) {
        return new Result<T>(Constants.SUCCESS.code, true, message, data);
    }


    public static <T> Result<T> fail() {
        return new Result<T>(Constants.INTERNAL_SERVER_ERROR.code, false, "操作失败！", null);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<T>(Constants.INTERNAL_SERVER_ERROR.code, false, "操作失败！", data);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<T>(Constants.INTERNAL_SERVER_ERROR.code, false, message, null);
    }

    public static <T> Result<T> fail(Integer code) {
        return new Result<T>(code, false, "操作失败！", null);
    }

    public static <T> Result<T> fail(String message, T data) {
        return new Result<T>(Constants.INTERNAL_SERVER_ERROR.code, false, message, data);
    }

    public static <T> Result<T> fail(Integer code, T data) {
        return new Result<T>(code, false, "操作失败！", data);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<T>(code, false, message, null);
    }

    public static <T> Result<T> fail(Integer code, String message, T data) {
        return new Result<T>(code, false, message, data);
    }


    public Result(Integer code, Boolean success, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
