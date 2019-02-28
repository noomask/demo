package com.example.demo.role.controller;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.role.pojo.Role;
import com.example.demo.role.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/roles")
public class RoleAction {

    @Resource
    private RoleService roleService;

    @GetMapping
    public JsonDto getAll(){
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public JsonDto getRoleById(@PathVariable int id){
        return roleService.getById(id);
    }

    @PostMapping
    public JsonDto save(@RequestBody Role role){
        return roleService.save(role);
    }

    @PutMapping
    public JsonDto update(@RequestBody Role role){
        return roleService.update(role);
    }

    @DeleteMapping("/{id}")
    public JsonDto remove(@PathVariable int id){
        return roleService.remove(id);
    }

    @PostMapping("/{roleId}/privileges/menus")
    public JsonDto addMenuPrivilege(@PathVariable int roleId, @RequestBody Map map){
        int menuId = Integer.parseInt((String) map.get("menuId"));
        return roleService.addMenuPrivilege(roleId, menuId);
    }

    @DeleteMapping("/{roleId}/privileges/menus/{menuId}")
    public JsonDto removeMenuPrivilege(@PathVariable int roleId, @PathVariable int menuId){
        return roleService.removeMenuPrivilege(roleId, menuId);
    }

    @GetMapping("/{roleId}/privileges/menus")
    public JsonDto getPrivilege(@PathVariable int roleId){
        return roleService.getMenuPrivilege(roleId);
    }

}
