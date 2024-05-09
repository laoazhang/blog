package com.laoazhang.utils;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 16:56
 * @Description:
 * @Version 1.0
 */
public class R<T> {
    // 响应状态码
    private Integer code;

    // 操作结果
    private Boolean success;

    // 提示语
    private String msg;

    // 响应数据
    private T data;

    public static <T> R<T> ok() {
        return new R<T>(200, true, "操作成功", null);
    }

    public static <T> R<T> ok(T data) {
        return new R<T>(200, true, "操作成功", data);
    }

    public static <T> R<T> ok(String message) {
        return new R<T>(200, true, message, null);
    }

    public static <T> R<T> ok(String message, T data) {
        return new R<T>(200, true, message, data);
    }


    public static <T> R<T> fail() {
        return new R<T>(500, false, "操作失败！", null);
    }

    public static <T> R<T> fail(T data) {
        return new R<T>(500, false, "操作失败！", data);
    }

    public static <T> R<T> fail(String message) {
        return new R<T>(500, false, message, null);
    }

    public static <T> R<T> fail(Integer code) {
        return new R<T>(code, false, "操作失败！", null);
    }

    public static <T> R<T> fail(String message, T data) {
        return new R<T>(500, false, message, data);
    }

    public static <T> R<T> fail(Integer code, T data) {
        return new R<T>(code, false, "操作失败！", data);
    }

    public static <T> R<T> fail(Integer code, String message) {
        return new R<T>(code, false, message, null);
    }

    public static <T> R<T> fail(Integer code, String message, T data) {
        return new R<T>(code, false, message, data);
    }


    public R(Integer code, Boolean success, String msg, T data) {
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
