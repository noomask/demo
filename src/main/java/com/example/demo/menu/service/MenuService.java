package com.example.demo.menu.service;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.menu.pojo.Menu;

import java.util.List;

public interface MenuService {

	JsonDto getAll();
	
	JsonDto getById(int id);

	JsonDto getSelf();

	JsonDto save(Menu menu);
	
	JsonDto update(Menu menu);
	
	JsonDto remove(int id);

	List<Menu> getParentList(int id);

	List<Menu> getchildList(int id);

}
