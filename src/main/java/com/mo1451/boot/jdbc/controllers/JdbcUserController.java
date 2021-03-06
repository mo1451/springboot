package com.mo1451.boot.jdbc.controllers;

import com.mo1451.boot.jdbc.dto.User;
import com.mo1451.boot.jdbc.service.JdbcUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jdbc")
@Api(value = "JdbcUserController", description = "jdbc查询user")
public class JdbcUserController {
    @Autowired
    private JdbcUserService jdbcUserService;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return jdbcUserService.getList();
    }

}
