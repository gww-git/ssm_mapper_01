package com.sz.service;

import com.sz.entity.Users;
import com.sz.mapper.UsersMapper;
import com.sz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public interface IUserService {

    public List<Users> ByUsers();

    public List<Users> ByUsersName(String name);

    public int update(Users users);

    public List<Users> ByUsers2(String name);

    public int delete(int id);

    public int save(Users users);

    public List<Users> pageUsers();

    public List<Users> orderByUsers();



}
