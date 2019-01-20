package com.example.demo.dict.service.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.dto.DTOs;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.dict.mapper.DictMapper;
import com.example.demo.dict.pojo.Dict;
import com.example.demo.dict.service.DictService;
import org.springframework.util.ObjectUtils;

@Service
public class DictServiceImpl implements DictService {

	@Resource
	private DictMapper dictMapper;
	
	@Override
	public JsonDto getAll() {
		List<Dict> list = dictMapper.selectAll();
		if(ObjectUtils.isEmpty(list)) {
			return DTOs.getJson("获取字典列表成功", list);
		}
		List<Integer> index = new LinkedList<>();
		List<Dict> result = new LinkedList<Dict>();
		boolean flag = true;
		for (Dict dict : list) {
			if(dict.getPid() == 0) {
				result.add(dict);
				index.add(dict.getId());
				continue;
			}
			if(flag) {
				Collections.reverse(result);
				Collections.reverse(index);
				flag = false;
			}
			int i = index.indexOf(dict.getPid());
			if(i >= 0) {
				result.add(i+1, dict);
				index.add(i+1, dict.getId());
			}
		}
		return DTOs.getJson("获取字典列表成功", result);
	}

	@Override
	public JsonDto getById(int id) {
		Dict dict = dictMapper.selectById(id);
		return DTOs.getJson("查询成功", dict);
	}
	
	@Override
	public JsonDto save(Dict dict) {
		dictMapper.insert(dict);
		return DTOs.getJson("添加成功");
	}

	@Override
	@Transactional
	public JsonDto update(Dict dict) {
		dictMapper.updateById(dict);
		dictMapper.updateShow(dict);
		return DTOs.getJson("修改成功");
	}

	@Override
	public JsonDto remove(int id) {
		int count = dictMapper.countByPid(id);
		if(count > 0) {
			return DTOs.getJson(false, "请先删除下级节点");
		}
		dictMapper.deleteById(id);
		return DTOs.getJson("删除成功");
	}

}
