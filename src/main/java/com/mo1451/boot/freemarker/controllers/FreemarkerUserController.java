package com.mo1451.boot.freemarker.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemarker")
@Api(value = "FreemarkerUserController", description = "freemarker 显示")
public class FreemarkerUserController {
    @Value("${msg:Welcome!}")
    private String msg;

    /**
     * get a page
     *
     * @return a page with name called return value
     */
    @RequestMapping("/login")
    public String getLoginPage(ModelMap map) {
        map.put("welcomeMsg", this.msg);
        return "loginf";
    }

}
