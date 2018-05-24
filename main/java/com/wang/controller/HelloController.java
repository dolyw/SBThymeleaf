package com.wang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/24 16:22
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
}