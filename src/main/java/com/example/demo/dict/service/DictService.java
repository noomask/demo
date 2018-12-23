package com.example.demo.dict.service;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.dict.entity.Dict;

public interface DictService {

	JsonDto getAlldict();
	
	JsonDto getById(int id);
	
	JsonDto add(Dict dict);
	
	JsonDto save(Dict dict);
	
	JsonDto remove(int id);
	
}
