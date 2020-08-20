package com.sz.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.entity.Users;
import com.sz.service.IUserService;
import com.sz.service.impl.UserServiceImpl;
import com.sz.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/byuser")
    public List<Users> BuUsers(){
        return userService.ByUsers();
    }


    @RequestMapping("/byname")
    public List<Users> ByUserLikeName(){
        return userService.ByUsersName("肖");
    }

    @RequestMapping("/byname2")
    public List<Users> ByUserLikeNameOrId(){
        return userService.ByUsers2(null);
    }


    @RequestMapping("/update")
    public int update(){
        Users users=new Users();
        users.setId(10);
        users.setName(" 萧筱");
        return userService.update(users);
    }


    @RequestMapping("/delete")
    public int delete(){
        return userService.delete(10);
    }


    @RequestMapping("/save")
    public int save(){
        Users users=new Users();
        users.setName("");
        return userService.save(users);
    }



    //分页
    @RequestMapping("/pageUsers/{id}/{row}")
    public List<Users> pageUsers(@PathVariable(name = "id") int id,@PathVariable(name = "row") int row){
        PageHelper.startPage(id, row);
        List<Users> users = userService.pageUsers();
        Page<Users> pages=(Page<Users>)users;
        PageUtil<Users> pageUtil= new PageUtil
                (pages.getTotal(),
                pages.getResult(),
                pages.getPageSize(),
                pages.getPages(),
                pages.getPageNum());
        return pages.getResult();
    }


    //排序
    @GetMapping("/orderByUsers")
    public List<Users> orderByUsers(){
        List<Users> users = userService.orderByUsers();
        return users;
    }

}
