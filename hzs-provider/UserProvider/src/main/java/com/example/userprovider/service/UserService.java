package com.example.userprovider.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.Entity.User;
import com.example.hzscommon.uitl.Msg;

import java.util.Map;


public interface UserService extends IService<User> {

    Msg UserLogin(UserDto userDto);
    Msg UserRegister(UserDto userDto);
}
