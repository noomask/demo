package com.example.demo.menu.service.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.demo.common.dto.DTOs;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.menu.mapper.MenuMapper;
import com.example.demo.menu.pojo.Menu;
import com.example.demo.menu.service.MenuService;

@Service
public class MenuServiceImpl<V> implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public JsonDto getAll() {
		List<Menu> list = menuMapper.selectAll();
		if(ObjectUtils.isEmpty(list)) {
			return DTOs.getJson("获取菜单列表成功", list);
		}
		List<Integer> index = new LinkedList<>();
		List<Menu> result = new LinkedList<Menu>();
		boolean flag = true;
		for (Menu menu : list) {
			if(menu.getPid() == 0) {
				result.add(menu);
				index.add(menu.getId());
				continue;
			}
			if(flag) {
				Collections.reverse(result);
				Collections.reverse(index);
				flag = false;
			}
			int i = index.indexOf(menu.getPid());
			if(i >= 0) {
				result.add(i+1, menu);
				index.add(i+1, menu.getId());
			}
		}
		return DTOs.getJson("获取菜单列表成功", result);
	}

	@Override
	public JsonDto getById(int id) {
		Menu menu = menuMapper.selectById(id);
		return DTOs.getJson("获取菜单信息成功", menu);
	}

	@Override
	public JsonDto save(Menu menu) {
		menuMapper.insert(menu);
		return DTOs.getJson("保存成功");
	}

	@Override
	@Transactional
	public JsonDto update(Menu menu) {
		menuMapper.updateById(menu);
		menuMapper.updateShow(menu);
		return DTOs.getJson("修改成功");
	}

	@Override
	public JsonDto remove(int id) {
		int count = menuMapper.countByPid(id);
		if(count > 0) {
			return DTOs.getJson(false, "请先删除子菜单");
		}
		menuMapper.deleteById(id);
		return DTOs.getJson("删除成功");
	}

}
