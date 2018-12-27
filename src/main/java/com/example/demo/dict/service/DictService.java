package com.example.demo.dict.service;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.dict.pojo.Dict;

public interface DictService {

	JsonDto getAll();
	
	JsonDto getById(int id);
	
	JsonDto save(Dict dict);
	
	JsonDto update(Dict dict);
	
	JsonDto remove(int id);
	
}
