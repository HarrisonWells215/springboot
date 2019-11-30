package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * ClassName HelloController
 **/
@Controller//接收前端请求
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
