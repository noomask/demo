package com.example.demo.common.dto;

public class Page {

	/**
	 * 请求序号
	 */
	private Integer draw =1;
	/**
	 * 开始位置
	 */
	private Integer limit = 0;
	/**
	 * 每页条数
	 */
	private Integer offset = 10;
	
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
}
