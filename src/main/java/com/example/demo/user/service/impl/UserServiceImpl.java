package com.example.demo.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.common.dto.DTOs;
import com.example.demo.common.dto.DataTableDto;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.common.dto.Page;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.pojo.User;
import com.example.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public JsonDto getAll() {
		List<User> list = userMapper.selectAll();
		return DTOs.getJson("获取用户列表成功", list);
	}
	
	@Override
	public JsonDto getPage(Page page) {
		if(page == null) {
			page = new Page();
		}
		List<User> list = userMapper.select4Page(page.getLimit(), page.getOffset());
		int total = userMapper.count4Page();
		DataTableDto dt = DTOs.getDataTable(page.getDraw(), total, total, list);
		return DTOs.getJson("获取用户列表成功", dt);
	}

	@Override
	public JsonDto save(User user) {
		userMapper.insert(user);
		return DTOs.getJson("添加用户成功");
	}

	@Override
	public JsonDto update(User user) {
		userMapper.updateById(user);
		return DTOs.getJson("修改用户信息成功");
	}

	@Override
	public JsonDto removeById(int id) {
		userMapper.deleteById(id);
		return DTOs.getJson("删除用户信息成功");
	}

	@Override
	public JsonDto getById(int id) {
		User user = userMapper.selectById(id);
		return DTOs.getJson("查询用户信息成功", user);
	}

}
