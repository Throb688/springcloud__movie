package com.example.userconsumer.controller;

import com.example.hzscommon.Dto.EvaluateDto;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.uitl.Msg;
import com.example.userconsumer.feign.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userconsumer")
public class UserConsumerService {

    @Autowired
    UserFeignService userFeignService;

    @PostMapping("/login")
    public Msg Login(@RequestBody UserDto userDto){
        return userFeignService.Login(userDto);
    }

    @PostMapping("/registration")
    public Msg Register(@RequestBody UserDto userDto){
        return userFeignService.Register(userDto);
    }


    @PostMapping("/addEvaluate")
    public Msg addEvaluate(@RequestBody EvaluateDto userDto){
        return userFeignService.addEvaluate(userDto);
    }

    @GetMapping("/findEvaluate/{movie}")
    public Msg findEvaluate(@PathVariable("movie") Integer movie){
        return userFeignService.findEvaluate(movie);
    }

    @GetMapping("/")
    public Msg UserList(){
        return userFeignService.UserList();
    }
}
