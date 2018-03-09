package com.mo1451.boot.webSocket.controllers;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    @RequestMapping("/")
    public String webSocket(){
        return "websocket";
    }
}
