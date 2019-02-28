package com.example.demo.privilege.service.impl;

import com.example.demo.common.dto.DTOs;
import com.example.demo.common.dto.JsonDto;
import com.example.demo.privilege.service.PrivilegeService;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Override
    public JsonDto getAll() {
        return DTOs.getJson("获取权限列表成功");
    }

}
