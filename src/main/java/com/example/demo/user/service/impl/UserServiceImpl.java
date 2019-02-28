package com.example.demo.user.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.demo.common.Const;
import org.springframework.stereotype.Service;

import com.example.demo.common.dto.DTOs;
import com.example.demo.common.dto.DataTableDto;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.common.dto.Page;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.pojo.User;
import com.example.demo.user.service.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private HttpSession session;

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
	public JsonDto register(User user) {
		User u = userMapper.selectIsRegister(user);
		if(u != null){
			return DTOs.getJson(false, "该账号已注册");
		}
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);
		byte[] bytes = user.getPassword().concat(salt).getBytes();
		String pwd = DigestUtils.md5DigestAsHex(bytes);
		user.setPassword(pwd);
		userMapper.register(user);
		return DTOs.getJson("注册成功");
	}

	@Override
	public JsonDto login(User user) {
		List<User> users = userMapper.selectForLogin(user);
		if (ObjectUtils.isEmpty(users)) {
			return DTOs.getJson(false, "该账号未注册");
		}
		for (User u: users) {
			byte[] bytes = user.getPassword().concat(u.getSalt()).getBytes();
			String pwd = DigestUtils.md5DigestAsHex(bytes);
			if(u.getPassword().equals(pwd)){
				session.setAttribute(Const.USERINFO, u);
				return DTOs.getJson("登陆成功");
			}
		}
		return DTOs.getJson(false, "密码错误");
	}

	@Override
	public JsonDto getById(int id) {
		User user = userMapper.selectById(id);
		return DTOs.getJson("查询用户信息成功", user);
	}

}
