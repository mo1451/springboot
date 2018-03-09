package com.mo1451.boot.security.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SecurityController {

    @Value("${msg:Welcome!}")
    private String msg;

    @RequestMapping("/login")
    public String getLoginPage(ModelMap map){
        map.put("welcomeMsg",this.msg);
        return "login";
    }

    @RequestMapping("/")
    public String index(ModelMap model){
        List<Map<String,String>> maps = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("title","测试标题");
        maps.add(map);

        Map<String,String> content = new HashMap<>();
        map.put("content","测试内容");
        maps.add(content);

        Map<String,String> etraInfo = new HashMap<>();
        map.put("etraInfo","额外信息，只对管理员显示");
        maps.add(etraInfo);

        model.addAttribute("msg", map);
        return "main";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }
}

