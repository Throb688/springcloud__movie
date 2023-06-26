package com.example.userprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.Entity.User;
import com.example.hzscommon.uitl.Msg;
import com.example.hzscommon.uitl.PasswordUtils;
import com.example.userprovider.mapper.UserMapper;
import com.example.userprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public Msg UserLogin(UserDto userDto) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("username",userDto.getUsername());
        qw.eq("password", PasswordUtils.encryptPassword(userDto.getPassword()));
        User flag = userMapper.selectOne(qw);

        if (!ObjectUtils.isEmpty(flag)) return Msg.success("登录成功").addData("token",flag.getId());
        return Msg.fail();
    }

    @Override
    public Msg UserRegister(UserDto userDto) {
        User user = new User();
        user.setPassword(PasswordUtils.encryptPassword(userDto.getPassword()));
        user.setUsername(userDto.getUsername());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        user.setRegistrationdate(formattedDateTime);
        userMapper.insert(user);
        return Msg.success("注册成功");
    }


}
