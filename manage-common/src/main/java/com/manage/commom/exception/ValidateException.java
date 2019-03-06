package com.manage.commom.exception;


import com.manage.commom.enums.ErrorCode;

/**
 * 清算结算部门通用参数校验异常类
 * @author dongleia
 * @since 2016.12.17
 * 
 */
public class ValidateException extends RuntimeException {

	private static final long serialVersionUID = 5775248438377905813L;

	private ErrorCode errorCode;

	private Exception e;

	public ValidateException() {
		super();
	}

	public ValidateException(String message) {
		super(message);
	}
	
	public ValidateException(ErrorCode errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ValidateException(ErrorCode errorCode,String message, Exception e) {
		super(message);
		this.errorCode = errorCode;
		this.e = e;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
}
