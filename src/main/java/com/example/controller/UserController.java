package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "查询用户",notes = "查询所有用户信息",httpMethod = "GET")
    @GetMapping("/getMessage")
    public List<User> getMessage(){
        try {
            return userService.findUsers();
        } catch (Exception e) {
           throw new RuntimeException("查询结果异常");
        }
    }

    @ApiOperation(value = "查询用户",notes ="根据ID查询用户信息",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "ID",value = "用户ID",required = true,dataTypeClass = Integer.class)})
    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable("id") int id){
        try {
            return userService.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询结果异常");
        }
    }

    @ApiOperation(value = "保存",notes ="保存用户信息",httpMethod = "POST")
    @ApiImplicitParams({@ApiImplicitParam(name = "user",value = "用户数据",required = true,dataTypeClass = User.class)})
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        try {
            userService.saveUser(user);
            return "{code:200,message:成功保存}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{code:100,message:失败保存}";
        }
    }

}
