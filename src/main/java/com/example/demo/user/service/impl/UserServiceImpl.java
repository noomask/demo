package com.example.demo.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.common.dto.DTOFactory;
import com.example.demo.common.dto.JsonDto;
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
		return DTOFactory.getJsonDto("获取用户列表成功", list);
	}

	@Override
	public JsonDto save(User user) {
		userMapper.insert(user);
		return DTOFactory.getJsonDto("添加用户成功");
	}

	@Override
	public JsonDto update(User user) {
		userMapper.updateById(user);
		return DTOFactory.getJsonDto("修改用户信息成功");
	}

	@Override
	public JsonDto removeById(int id) {
		userMapper.deleteById(id);
		return DTOFactory.getJsonDto("删除用户信息成功");
	}

	@Override
	public JsonDto getById(int id) {
		User user = userMapper.selectById(id);
		return DTOFactory.getJsonDto("查询用户信息成功", user);
	}
	
}
