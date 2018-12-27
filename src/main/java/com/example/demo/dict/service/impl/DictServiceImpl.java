package com.example.demo.dict.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.common.dto.DTOFactory;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.dict.mapper.DictMapper;
import com.example.demo.dict.pojo.Dict;
import com.example.demo.dict.service.DictService;

@Service
public class DictServiceImpl implements DictService {

	@Resource
	private DictMapper dictMapper;
	
	@Override
	public JsonDto getAll() {
		List<Dict> list = dictMapper.selectAll();
		return DTOFactory.getJsonDto("获取字典列表成功", list);
	}

	@Override
	public JsonDto getById(int id) {
		Dict dict = dictMapper.selectById(id);
		return DTOFactory.getJsonDto("查询成功", dict);
	}
	
	@Override
	public JsonDto save(Dict dict) {
		dictMapper.insert(dict);
		return DTOFactory.getJsonDto("添加成功");
	}

	@Override
	public JsonDto update(Dict dict) {
		dictMapper.updateById(dict);
		return DTOFactory.getJsonDto("修改成功");
	}

	@Override
	public JsonDto remove(int id) {
		dictMapper.deleteById(id);
		return DTOFactory.getJsonDto("删除成功");
	}

}
