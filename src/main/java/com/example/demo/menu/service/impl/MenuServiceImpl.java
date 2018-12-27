package com.example.demo.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.common.dto.DTOFactory;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.menu.mapper.MenuMapper;
import com.example.demo.menu.pojo.Menu;
import com.example.demo.menu.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuMapper menuMapper;
	
	@Override
	public JsonDto getAll() {
		List<Menu> list = menuMapper.selectAll();
		return DTOFactory.getJsonDto("获取菜单列表成功", list);
	}

	@Override
	public JsonDto getById(int id) {
		Menu menu = menuMapper.selectById(id);
		return DTOFactory.getJsonDto("获取菜单信息成功", menu);
	}

	@Override
	public JsonDto save(Menu menu) {
		menuMapper.insert(menu);
		return DTOFactory.getJsonDto("保存成功");
	}

	@Override
	public JsonDto update(Menu menu) {
		menuMapper.updateById(menu);
		return DTOFactory.getJsonDto("修改成功");
	}

	@Override
	public JsonDto remove(int id) {
		menuMapper.deleteById(id);
		return DTOFactory.getJsonDto("删除成功");
	}

}
