package com.example.demo.common.dto;

public class DTOs {

	private DTOs() {}
	
	public static JsonDto getJson(String msg) {
		return getJson(true, msg, null);
	}
	
	public static JsonDto getJson(String msg, Object data) {
		return getJson(true, msg, data);
	}
	
	public static JsonDto getJson(boolean success, String msg) {
		return getJson(success, msg, null);
	}
	
	public static JsonDto getJson(boolean success, String msg, Object data) {
		JsonDto dto = new JsonDto();
		dto.setSucess(success);
		dto.setMsg(msg);
		dto.setData(data);
		return dto;
	}
	
	public static DataTableDto getDataTable(Integer draw, Integer recordsTotal, Integer recordsFiltered, Object data) {
		DataTableDto dto = new DataTableDto();
		dto.setDraw(draw);
		dto.setRecordsTotal(recordsTotal);
		dto.setRecordsFiltered(recordsFiltered);
		dto.setData(data);
		return dto;
	}
	
}
