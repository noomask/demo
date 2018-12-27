package com.example.demo.menu.service;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.menu.pojo.Menu;

public interface MenuService {

	JsonDto getAll();
	
	JsonDto getById(int id);
	
	JsonDto save(Menu menu);
	
	JsonDto update(Menu menu);
	
	JsonDto remove(int id);
	
}
