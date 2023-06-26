package com.example.sessionconsumer.controller;


import com.example.hzscommon.Entity.Session;
import com.example.hzscommon.uitl.Msg;
import com.example.sessionconsumer.feign.SessionFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessionconsumer")
public class SessionConsumerService {

    @Autowired
    SessionFeignService sessionFeignService;

    @GetMapping("/getSessionList/{id}")
    public Msg getSessionList(@PathVariable("id") Integer id){
        return sessionFeignService.getSessionList(id);
    }

    @GetMapping("/getSessionListById/{id}")
    public Msg getSessionListById(@PathVariable("id") Integer id){
        return sessionFeignService.getSessionListById(id);
    }

    @GetMapping("/")
    public Msg getSession(){
        return sessionFeignService.getSession();
    }

    @PostMapping("/addSession")
    public Msg addSession(@RequestBody Session session){
        return sessionFeignService.addSession(session);
    }

    @GetMapping("/delSession/{id}")
    public Msg delSession(@PathVariable("id") Integer id){
        return sessionFeignService.delSession(id);
    }
}
