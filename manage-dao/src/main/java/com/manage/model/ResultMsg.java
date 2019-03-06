package com.manage.model;

import java.io.Serializable;
import java.util.List;

/**
 * hejinping 2016.3.23
 */
public class ResultMsg<T> implements Serializable{
	private static final long serialVersionUID = 1096311515906831278L;

	private boolean result;//处理状态
	private int resultcode;// 返回结果编码. 比如1成功,0失败,-1未确定. 根据业务确定.
	private Object data;//其他数据
	
	//字符串的返回Code
	private String resultstrcode;//返回结果编码.兼容ApiResultMsg.

	public String getResultstrcode() {
		return resultstrcode;
	}

	public void setResultstrcode(String resultstrcode) {
		this.resultstrcode = resultstrcode;
	}

	/**
	 * 1成功,0失败,-1未确认
	 * @return
	 */
	public int getResultcode() {
		return resultcode;
	}

	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}

	@Override
	public String toString() {
		return "ResultMsg{" +
				"result=" + result +
				", resultcode=" + resultcode +
				", data=" + data==null?"":data +
				", msg='" + msg + '\'' +
				", errorMsg='" + errorMsg + '\'' +
				", rows=" + rows ==null?"":rows+
				", total=" + total +
				'}';
	}

	private String msg;//消息

	private String errorMsg;
	private List<T> rows;//bootstarp分页设置每一行数据
	private Long total;//分页设置总数
	private Integer records;//jqGrid分页总数

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(long total2) {
		this.total = total2;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}
}
