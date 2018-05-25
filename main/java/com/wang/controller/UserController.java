package com.wang.controller;

import com.wang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/24 16:22
 */
@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.selectAll());
        return "index";
    }
}