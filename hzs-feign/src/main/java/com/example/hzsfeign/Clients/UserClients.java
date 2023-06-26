package com.example.hzsfeign.Clients;


import com.example.hzscommon.Dto.EvaluateDto;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.impl.UserClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UserService",path = "/user",fallback = UserClientServiceImpl.class)
public interface UserClients {

    @PostMapping("/login")
    Msg Login(@RequestBody UserDto userDto);

    @PostMapping("/registration")
    Msg Register(@RequestBody UserDto userDto);

    @PostMapping("/addEvaluate")
     Msg addEvaluate(@RequestBody EvaluateDto userDto);

    @GetMapping("/findEvaluate/{movie}")
     Msg findEvaluate(@PathVariable("movie") Integer movie);

    @GetMapping("/")
    Msg UserList();
}
