package com.laoazhang.utils;

import com.laoazhang.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 16:56
 * @Description: 统一返回结果集
 * @Version 1.0
 */
@Data
@ApiModel(value = "统一返回类型对象")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -3960261604608758516L;
    @ApiModelProperty(value = "状态码")
    private int code;
    @ApiModelProperty(value = "状态信息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public static <T> Result<T> success() {
        return new Result<>();
    }

    /**
     * 成功,默认状态码,返回消息,自定义返回数据
     *
     * @param data 自定义返回数据
     * @param <T>  返回类泛型,不能为String
     * @return 通用返回Result
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    /**
     * 成功,默认状态码,自定义返回消息,返回数据
     *
     * @param msg  自定义返回消息
     * @param data 自定义返回数据
     * @param <T>  返回类泛型
     * @return 通用返回Result
     */
    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(msg, data);
    }

    /**
     * 成功,默认状态码,自定义返回消息,无返回数据
     *
     * @param msg 自定义返回消息
     * @param <T> 返回类泛型
     * @return 通用返回Result
     */
    public static <T> Result<T> success(String msg) {
        return new Result<>(msg);
    }

    /**
     * 失败,默认状态码,返回消息,无返回数据
     *
     * @param <T> 返回类泛型
     * @return 通用返回Result
     */
    public static <T> Result<T> error() {
        return new Result<>(ResultCodeEnum.ERROR);
    }

    /**
     * 失败,默认状态码,自定义返回消息,无返回数据
     *
     * @param <T> 返回类泛型
     * @return 通用返回Result
     */
    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultCodeEnum.ERROR.getCode(), msg);
    }

    /**
     * 失败,自定义状态码,返回消息,无返回数据
     *
     * @param code 自定义状态码
     * @param msg  自定义返回消息
     * @param <T>  返回类泛型
     * @return 通用返回Result
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg);
    }

    /**
     * 失败,使用CodeMsg状态码,返回消息,无返回数据
     *
     * @param resultCode CodeMsg,参数如下:
     *                   <p> code 状态码
     *                   <p> msg  返回消息
     * @param <T>        返回类泛型
     * @return 通用返回Result
     */
    public static <T> Result<T> error(ResultCodeEnum resultCode) {
        return new Result<>(resultCode);
    }

    /**
     * 成功构造器,无返回数据
     */
    private Result() {
        this(ResultCodeEnum.SUCCESS);
    }

    /**
     * 成功构造器,自定义返回数据
     *
     * @param data 返回数据
     */
    private Result(T data) {
        this(ResultCodeEnum.SUCCESS, data);
    }

    /**
     * 成功构造器,自定义返回消息,无返回数据
     *
     * @param msg 返回消息
     */
    private Result(String msg) {
        this(ResultCodeEnum.SUCCESS.getCode(), msg);
    }

    /**
     * 构造器,自定义状态码,返回消息
     *
     * @param code 状态码
     * @param msg  返回消息
     */
    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功构造器,自定义返回信息,返回数据
     *
     * @param msg  返回信息
     * @param data 返回数据
     */
    private Result(String msg, T data) {
        this(ResultCodeEnum.SUCCESS.getCode(), msg, data);
    }

    /**
     * 构造器,自定义状态码,返回消息,返回数据
     *
     * @param code 状态码
     * @param msg  返回消息
     * @param data 返回数据
     */
    private Result(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    /**
     * 构造器,使用CodeMsg状态码与返回信息,自定义返回数据
     *
     * @param resultCode CodeMsg,参数如下:
     *                   <p> code 状态码
     *                   <p> msg  返回消息
     * @param data       返回数据
     */
    private Result(ResultCodeEnum resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    /**
     * 构造器,使用CodeMsg状态码与返回信息
     *
     * @param resultCode CodeMsg,参数如下:
     *                   <p> code 状态码
     *                   <p> msg  返回消息
     */
    private Result(ResultCodeEnum resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }
}
