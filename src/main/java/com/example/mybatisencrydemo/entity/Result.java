package com.example.mybatisencrydemo.entity;


import java.util.Objects;

/**
 * @author tianzhuang
 * @version 1.0
 * @date 2022/9/8
 */
public class Result<T> {

    private static final long serialVersionUID = 1L;
    private Boolean isSuccess;
    private Integer code;
    private String msg;
    private T data;
    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";

    public Result() {
    }


    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        if (!Objects.isNull(data)) {
            this.data = data;
        }

    }

    public Result(Boolean isSuccess, Integer code, String msg, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getIsSuccess() {
        return this.isSuccess;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result success() {
        return success("操作成功");
    }

    public static Result success(Object data) {
        return success("操作成功", data);
    }

    public static Result success(String msg) {
        return success(msg, (Object)null);
    }

    public static Result success(String msg, Object data) {
        return new Result(true, 200, msg, data);
    }

    public static Result error() {
        return error("操作失败");
    }

    public static Result error(String msg) {
        return error(msg, (Object)null);
    }

    public static Result error(String msg, Object data) {
        return new Result(false, 500, msg, data);
    }

    public static Result error(int code, String msg) {
        return new Result(false, code, msg, (Object)null);
    }

}
