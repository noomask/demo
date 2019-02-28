package com.example.demo.role.service;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.role.pojo.Role;

public interface RoleService {

    JsonDto getAll();

    JsonDto getById(int id);

    JsonDto save(Role role);

    JsonDto update(Role role);

    JsonDto remove(int id);

    JsonDto addMenuPrivilege(int roleId, int menuId);

    JsonDto removeMenuPrivilege(int roleId, int menuId);

    JsonDto getMenuPrivilege(int roleId);

}
