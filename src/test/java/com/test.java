package com;

import com.sz.entity.Users;
import com.sz.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test {

    @Autowired
    private IUserService userService;

    @Test
    public void test1(){
        List<Users> users = userService.orderByUsers();
        System.out.println(users);
    }


    @Test
    public void test2(){
        List<Users> users = userService.pageUsers();
        System.out.println(users);
    }
}
