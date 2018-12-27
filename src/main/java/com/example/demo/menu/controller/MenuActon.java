package com.example.demo.menu.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.menu.pojo.Menu;
import com.example.demo.menu.service.MenuService;

@RestController
@RequestMapping("menus")
public class MenuActon {

	@Resource
	private MenuService menuService;
	
	@GetMapping
	public JsonDto getAllMenus() {
		return menuService.getAll();
	}
	
	@GetMapping("/{id}")
	public JsonDto getMenuById(@PathVariable("id")int id) {
		return menuService.getById(id);
	}
	
	@PostMapping
	public JsonDto saveMenu(@RequestBody Menu menu) {
		return menuService.save(menu);
	}
	
	@PutMapping
	public JsonDto updateMenu(@RequestBody Menu menu) {
		return menuService.update(menu);
	}
	
	@DeleteMapping("/{id}")
	public JsonDto removeMenu(@PathVariable("id")int id) {
		return menuService.remove(id);
	}
	
}
