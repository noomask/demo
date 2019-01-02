package com.example.demo.user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.user.pojo.User;
import com.example.demo.user.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Resource
	private UserService userService;
	
	@GetMapping
	public JsonDto getAllUser() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public JsonDto getUserById(@PathVariable int id) {
		return userService.getById(id);
	}
	
	@PostMapping
	public JsonDto saveUser(User user) {
		return userService.save(user);
	}
	
	@PutMapping
	public JsonDto updateUser(User user) {
		return userService.update(user);
	}
	
	@DeleteMapping("/{id}")
	public JsonDto removeUser(@PathVariable int id) {
		return userService.removeById(id);
	}
	
}
