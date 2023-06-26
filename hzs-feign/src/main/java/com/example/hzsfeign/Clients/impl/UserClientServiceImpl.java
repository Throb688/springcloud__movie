package com.example.hzsfeign.Clients.impl;

import com.example.hzscommon.Dto.EvaluateDto;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.UserClients;

public class UserClientServiceImpl implements UserClients {
    @Override
    public Msg Login(UserDto userDto) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg Register(UserDto userDto) {
        return Msg.fail("服务不可用");
      }

    @Override
    public Msg addEvaluate(EvaluateDto userDto) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg findEvaluate(Integer movie) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg UserList() {
        return Msg.fail("服务不可用");
    }
}
