package com.manage.commom.http;

import java.io.Serializable;

/**
 * SimpleHttpResponse
 * Description SimpleHttpResponse
 * Copyrigth(C),2017,lx86468@126.com.com
 * Date 2017/5/16 0016
 *
 * @author lixiao on 2017/5/16 0016.
 * @version 1.0
 */
public class SimpleHttpResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int statusCode;
	private String entityString;
	private String errorMessage;

	/**
	 * @param statusCode
	 * @param entityString
	 */
	public SimpleHttpResponse(int statusCode, String entityString,
			String errorMessage) {
		super();
		this.statusCode = statusCode;
		this.entityString = entityString;
		this.errorMessage = errorMessage;
	}

	/**
	 * 是否成功
	 * 
	 * @return
	 */
	public boolean isRequestSuccess() {
		return HttpUtil.isRequestSuccess(statusCode);
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @return the entityString
	 */
	public String getEntityString() {
		return entityString;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
