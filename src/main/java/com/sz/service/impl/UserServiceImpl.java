package com.sz.service.impl;

import com.sz.entity.Users;
import com.sz.entity.UsersExample;
import com.sz.mapper.UsersMapper;
import com.sz.service.IUserService;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> ByUsers() {
        return usersMapper.selectByExample(null);
    }

    @Override
    public List<Users> ByUsersName(String name) {
        UsersExample usersExample=new UsersExample();
        usersExample.createCriteria()
                .andNameLike("%"+name+"%")
                .andIdBetween(10,15);
       return usersMapper.selectByExample(usersExample);
    }


    @Override
    public List<Users> ByUsers2(String name) {
        //如果直接在条件Criteria里面设置多个条件，那么他们都是and的关系
        //如果想使用or的关系，一个使用多个Criteria
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria()
                .andIdEqualTo(10);
        UsersExample.Criteria criteria1 = usersExample.createCriteria()
                .andNameLike("%" + name + "%");
        usersExample.or(criteria1);  //优先使用该条件，不满足再找criteria
        return usersMapper.selectByExample(usersExample);
    }

    @Override
    public int update(Users users) {
        UsersExample usersExample=new UsersExample();
        usersExample.createCriteria()
                .andIdEqualTo(users.getId());
        return usersMapper.updateByExample(users, usersExample);
    }

    @Override
    public int delete(int id) {
        UsersExample usersExample=new UsersExample();
        usersExample.createCriteria()
                .andIdEqualTo(id);
        return usersMapper.deleteByExample(usersExample);
    }


    @Override
    public int save(Users users) {
//        return usersMapper.insert(users); //不会保存值为null的值
        return usersMapper.insertSelective(users);  //相反,带有Selective

    }


    @Override
    public List<Users> pageUsers() {
        return usersMapper.selectByExample(null);
    }


    @Override
    public List<Users> orderByUsers() {
        UsersExample usersExample=new UsersExample();
        usersExample.setOrderByClause("id desc"); //根据id 倒序
        System.out.println("是否去重："+usersExample.isDistinct());//默认不去重
        return usersMapper.selectByExample(usersExample);
    }

}
