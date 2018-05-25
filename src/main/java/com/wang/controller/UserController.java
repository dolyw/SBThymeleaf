package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.entity.User;
import com.wang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/getUsers")
    public Map getUsers(int page, int limit){
        PageHelper.startPage(page, limit);
        List<User> users = userService.selectAll();
        PageInfo<User> selectPage = new PageInfo<User>(users);
        Map map = new HashMap();
        map.put("code", "0");
        //map.put("msg", "");
        map.put("count", selectPage.getTotal());
        map.put("data", selectPage.getList());
        return map;
    }
}