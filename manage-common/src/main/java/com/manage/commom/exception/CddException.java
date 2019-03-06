package com.manage.commom.exception;

import com.manage.commom.enums.ErrorCode;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public class CddException extends Exception {
    private static final long serialVersionUID = -5218633382701959157L;
    private String errorCode;
    private String errorMsg;
    private Exception exception;
    private ErrorCode errorCodeEnum;

    public Exception getException() {
        return exception;
    }

    public String getErrorCode() {
        return errorCode;
    }

    //定义无参构造方法
    public CddException() {
        super();
    }

    public CddException(String code) {
        super(code);
    }

    public CddException(ErrorCode errorCodeEnum) {
        super((errorCodeEnum.getMessage()));
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = "";
    }

    public CddException(ErrorCode errorCodeEnum,Exception e) {
        super((errorCodeEnum.getMessage()));
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = "";
        this.exception = e;
    }

    public String getErrorMsg() {
        String pattern = errorCodeEnum != null ? errorCodeEnum.getMessage() : "{0}";
        String arg = StringUtils.isBlank(errorMsg) ? "" : errorMsg;
        return pattern +  arg;
    }

    public CddException(ErrorCode errorCodeEnum, String errorMsg,Exception e) {
        super(errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = errorMsg;
        this.exception = e;
    }

    public ErrorCode getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCode errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

    public CddException(ErrorCode errorCodeEnum, Throwable th) {
        super(th);
        this.errorCodeEnum = errorCodeEnum;
    }

    public CddException(ErrorCode errorCodeEnum, String errorMsg, Throwable th) {
        super(errorCodeEnum.getMessage(), th);
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = errorMsg;
    }
}
