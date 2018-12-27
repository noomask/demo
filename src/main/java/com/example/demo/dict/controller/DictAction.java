package com.example.demo.dict.controller;

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
import com.example.demo.dict.pojo.Dict;
import com.example.demo.dict.service.DictService;

@RestController
@RequestMapping("/dict")
public class DictAction {

	@Resource
	private DictService dictService;
	
	@GetMapping
	public JsonDto getAllDict() {
		return dictService.getAll();
	}
	
	@GetMapping("/{id}")
	public JsonDto getDictById(@PathVariable("id")int id) {
		return dictService.getById(id);
	}
	
	@PostMapping
	public JsonDto saveDict(@RequestBody Dict dict) {
		return dictService.save(dict);
	}
	
	@PutMapping
	public JsonDto updateDict(@RequestBody Dict dict) {
		return dictService.update(dict);
	}
	
	@DeleteMapping("/{id}")
	public JsonDto removeDict(@PathVariable("id")int id) {
		return dictService.remove(id);
	}
	
}
