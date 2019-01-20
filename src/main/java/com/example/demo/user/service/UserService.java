package com.example.demo.user.service;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.common.dto.Page;
import com.example.demo.user.pojo.User;

public interface UserService {

	JsonDto getAll();
	
	JsonDto getPage(Page page);
	
	JsonDto getById(int id);
	
	JsonDto save(User user);
	
	JsonDto update(User user);
	
	JsonDto removeById(int id);
	
}
