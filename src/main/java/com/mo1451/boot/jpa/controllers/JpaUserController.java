package com.mo1451.boot.jpa.controllers;

import com.mo1451.boot.jpa.dto.User;
import com.mo1451.boot.jpa.service.JpaUserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jpa")
@Api(value = "JpaUserController", description = "jpa查询user")
public class JpaUserController {
    @Autowired
    private JpaUserRepository jpaUserRepository;

    @ApiOperation(value="获取用户详细信息", notes="获取用户全部详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/getUsers")
    @CachePut(value = "jpaUsers")
    public List<User> getUsers() {
        return jpaUserRepository.findAll();
    }

}
