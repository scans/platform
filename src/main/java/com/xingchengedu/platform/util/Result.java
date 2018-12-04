package com.xingchengedu.platform.util;

/**
 * Created by chencheng on 2018/12/4.
 */
public class Result<T> {
    private Boolean success;
    private T resultObj;
    private String errorMessage;

    public Result() {
    }

    public static <T> Result<T> of(T t, Boolean flag) {
        Result<T> rs = new Result<>();
        rs.setSuccess(flag);
        rs.setResultObj(t);
        return rs;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResultObj() {
        return resultObj;
    }

    public void setResultObj(T resultObj) {
        this.resultObj = resultObj;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
