package com.example.userprovider.controller;


import com.example.hzscommon.Dto.EvaluateDto;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.uitl.Msg;
import com.example.userprovider.service.EvaluateService;
import com.example.userprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EvaluateService evaluateService;


    @PostMapping("/login")
    public Msg Login(@RequestBody UserDto userDto){
        return userService.UserLogin(userDto);
    }

    @PostMapping("/registration")
    public Msg Registration(@RequestBody UserDto userDto){
        return userService.UserRegister(userDto);
    }

    @PostMapping("/addEvaluate")
    public Msg addEvaluate(@RequestBody EvaluateDto userDto){
        return evaluateService.addEvaluate(userDto);
    }

    @GetMapping ("/findEvaluate/{movie}")
    public Msg findEvaluate(@PathVariable("movie") Integer movie){
        return evaluateService.findEvaluate(movie);
    }

    @GetMapping("/")
    public Msg UserList(){
        return Msg.success().addData("mes",userService.list());
    }
}
