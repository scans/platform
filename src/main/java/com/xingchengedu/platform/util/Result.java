package com.xingchengedu.platform.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = -757959713205186605L;
    private boolean success;
    private String errorContext;
    private T resultObj;

    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String errorContext, T resultObj) {
        this.success = success;
        this.errorContext = errorContext;
        this.resultObj = resultObj;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorContext() {
        return this.errorContext;
    }

    public void setErrorContext(String errorContext) {
        this.errorContext = errorContext;
    }

    public T getResultObj() {
        return this.resultObj;
    }

    public void setResultObj(T resultObj) {
        this.resultObj = resultObj;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
