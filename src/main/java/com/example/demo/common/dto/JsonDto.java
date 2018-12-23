package com.example.demo.common.dto;

public class JsonDto {

	/**
	 * 是否成功
	 */
	private Boolean success;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 数据
	 */
	private Object data;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSucess(Boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
