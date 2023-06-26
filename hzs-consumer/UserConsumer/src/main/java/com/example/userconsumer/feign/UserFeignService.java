package com.example.userconsumer.feign;


import com.example.hzscommon.Dto.EvaluateDto;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.UserClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(name = "UserService",path = "/user")
public class UserFeignService implements UserClients {


    @Autowired
    private UserClients userClients;
    @Override
    public Msg Login(UserDto userDto) {
        return userClients.Login(userDto);
    }

    @Override
    public Msg Register(UserDto userDto) {
        return userClients.Register(userDto);
    }

    @Override
    public Msg addEvaluate(EvaluateDto userDto) {
        return userClients.addEvaluate(userDto);
    }

    @Override
    public Msg findEvaluate(Integer movie) {
        return userClients.findEvaluate(movie);
    }

    @Override
    public Msg UserList() {
        return userClients.UserList();
    }
}
