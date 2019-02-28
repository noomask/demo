package com.example.demo.role.service.impl;

import com.example.demo.common.dto.DTOs;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.menu.pojo.Menu;
import com.example.demo.menu.service.MenuService;
import com.example.demo.role.mapper.RoleMapper;
import com.example.demo.role.pojo.Role;
import com.example.demo.role.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    
    @Resource
    private MenuService menuService;

    @Override
    public JsonDto getAll() {
        List<Role> roles = roleMapper.selectAll();
        return DTOs.getJson("获取角色列表成功", roles);
    }

    @Override
    public JsonDto getById(int id) {
        Role role = roleMapper.selectById(id);
        return DTOs.getJson("获取角色信息成功", role);
    }

    @Override
    public JsonDto save(Role role) {
        roleMapper.insert(role);
        return DTOs.getJson("新增角色成功");
    }

    @Override
    public JsonDto update(Role role) {
        roleMapper.updateById(role);
        return DTOs.getJson("修改角色成功");
    }

    @Override
    public JsonDto remove(int id) {
        roleMapper.deleteById(id);
        return DTOs.getJson("删除角色成功");
    }

    @Override
    public JsonDto addMenuPrivilege(int roleId, int menuId) {
        List<Menu> parentList = menuService.getParentList(menuId);
        List<Menu> childList = menuService.getchildList(menuId);
        Set<Integer> set = new HashSet<>();
        if(!ObjectUtils.isEmpty(parentList)){
            for(Menu m : parentList){
                set.add(m.getId());
            }
        }
        if(!ObjectUtils.isEmpty(childList)){
            for(Menu m : childList){
                set.add(m.getId());
            }
        }
        Role role = roleMapper.selectById(roleId);
        if(role.getMenuPrivilege()!= null && !"".equals(role.getMenuPrivilege().trim())){
            String[] split = role.getMenuPrivilege().split(",");
            for (String s : split){
                set.add(Integer.parseInt(s));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int s : set){
            sb.append(",".concat(String.valueOf(s)));
        }
        String privilege = sb.toString();
        if(!ObjectUtils.isEmpty(privilege)){
            role.setMenuPrivilege(privilege.substring(1));
        }
        role.setUpdUser(223);
        roleMapper.updateMenuPrivilege(role);
        return DTOs.getJson("添加菜单权限成功", role.getMenuPrivilege());
    }

    @Override
    public JsonDto getMenuPrivilege(int roleId) {
        Role role = roleMapper.selectPrivilege(roleId);
        return DTOs.getJson("查询菜单权限成功", role.getMenuPrivilege());
    }

    @Override
    public JsonDto removeMenuPrivilege(int roleId, int menuId) {
        Role role = roleMapper.selectById(roleId);
        Set<Integer> set = new HashSet<>();
        if(role.getMenuPrivilege()!= null && !"".equals(role.getMenuPrivilege().trim())){
            String[] split = role.getMenuPrivilege().split(",");
            for (String s : split){
                set.add(Integer.parseInt(s));
            }
        }
        List<Menu> childList = menuService.getchildList(menuId);
        if(!ObjectUtils.isEmpty(childList)){
            for(Menu m : childList){
                set.remove(m.getId());
            }
        }
        if(ObjectUtils.isEmpty(set)){
            role.setMenuPrivilege(null);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int s : set){
                sb.append(",".concat(String.valueOf(s)));
            }
            role.setMenuPrivilege(sb.toString().substring(1));
        }
        role.setUpdUser(223);
        roleMapper.updateMenuPrivilege(role);
        return DTOs.getJson("移除菜单权限成功", role.getMenuPrivilege());
    }

}
