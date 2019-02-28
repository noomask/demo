package com.example.demo.privilege.controller;

import com.example.demo.common.dto.JsonDto;
import com.example.demo.privilege.service.PrivilegeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/privileges")
public class PrivilegeAction {

    @Resource
    private PrivilegeService privilegeService;

    @GetMapping
    public JsonDto getAll(){
        return privilegeService.getAll();
    }

}
