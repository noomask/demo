package com.example.demo.common.dto;

public class DTOFactory {

	private DTOFactory() {}
	
	public static JsonDto getJsonDto(String msg) {
		return getJsonDto(true, msg, null);
	}
	
	public static JsonDto getJsonDto(String msg, Object data) {
		return getJsonDto(true, msg, data);
	}
	
	public static JsonDto getJsonDto(boolean success, String msg) {
		return getJsonDto(success, msg, null);
	}
	
	public static JsonDto getJsonDto(boolean success, String msg, Object data) {
		JsonDto dto = new JsonDto();
		dto.setSucess(success);
		dto.setMsg(msg);
		dto.setData(data);
		return dto;
	}
	
}
