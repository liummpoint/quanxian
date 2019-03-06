package com.manage.commom.exception;


import com.manage.commom.enums.ErrorCode;

/**
 * 接口消息异常
 * @author fxl
 */
public class MessageException extends RuntimeException {

	private static final long serialVersionUID = -2263117584052924306L;

	private ErrorCode errorCode;
	
	public MessageException() {
		super();
	}

	public MessageException(String message) {
		super(message);
	}
	
	public MessageException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
}
