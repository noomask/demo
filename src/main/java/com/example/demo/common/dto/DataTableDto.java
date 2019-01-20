package com.example.demo.common.dto;

public class DataTableDto {

	/**
	 * 请求编号
	 */
	private Integer draw;
	/**
	 * 总记录条数
	 */
	private Integer recordsTotal;
	/**
	 * 过滤后的记录数
	 */
	private Integer recordsFiltered;
	/**
	 * 数据
	 */
	private Object data;
	
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
}
