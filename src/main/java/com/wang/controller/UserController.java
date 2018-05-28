package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.entity.User;
import com.wang.service.IUserService;
import com.wang.util.JsonListUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
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

    @RequestMapping(value = "/")
    @ApiIgnore
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/getUsers")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "limit", required = true, value = "条数", paramType = "query")
    })
    @ApiOperation(value = "AJAX获取所有用户", httpMethod = "POST", notes = "详细描述：返回所有用户JSON信息", response = Object.class)
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

    @ResponseBody
    @RequestMapping("/addOrUpdate")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = false, value = "用户ID", paramType = "query"),
            @ApiImplicitParam(name = "account", required = false, value = "帐号", paramType = "query"),
            @ApiImplicitParam(name = "password", required = false, value = "密码", paramType = "query"),
            @ApiImplicitParam(name = "username", required = false, value = "用户名", paramType = "query")
    })
    @ApiOperation(value = "添加或修改用户信息", httpMethod = "POST", notes = "详细描述：接收用户JSON信息添加或更新")
    public void addUser(@ApiIgnore User user){
        if(user.getId() == null){
            user.setRegtime(new Date());
            int count = userService.insert(user);
        }else{
            int count = userService.updateByPrimaryKeySelective(user);
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    @ApiImplicitParam(name = "jsons", required = true, value = "用户JsonList", paramType = "query")
    @ApiOperation(value = "删除用户", httpMethod = "POST", notes = "详细描述：接收批量用户JSON信息删除用户")
    public void delete(String jsons){
        List<User> users = JsonListUtil.jsonToList(jsons, User.class);
        /*for (User user: users) {
            userService.delete(user);
        }*/
        for (int i = 0; i < users.size(); i++) {
            userService.delete(users.get(i));
        }
    }

    @ResponseBody
    @RequestMapping("/findById")
    @ApiImplicitParam(name = "jsons", required = true, value = "用户JsonList", paramType = "query")
    @ApiOperation(value = "查找用户", httpMethod = "POST", notes = "详细描述：接收用户JSON信息查找用户", response = Object.class)
    public Map findById(String jsons){
        List<User> users = JsonListUtil.jsonToList(jsons, User.class);
        User user = userService.selectOne(users.get(0));
        Map map = new HashMap();
        map.put("obj", user);
        return map;
    }
}