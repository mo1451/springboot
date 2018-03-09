package com.mo1451.boot.mybatis.controllers;

import com.mo1451.boot.mybatis.dto.User;
import com.mo1451.boot.mybatis.service.MybatisUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
@Api(value = "MybatisUserController", description = "mybatis查询user")
public class MybatisUserController {
    @Autowired
    private MybatisUserService mybatisUserService;

    @GetMapping("/getUsers")
    @Cacheable(value = "users")
    public List<User> getUsers() {
        return mybatisUserService.getList();
    }

}
