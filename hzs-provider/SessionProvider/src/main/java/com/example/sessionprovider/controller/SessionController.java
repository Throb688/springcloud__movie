package com.example.sessionprovider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hzscommon.Entity.Session;
import com.example.hzscommon.uitl.Msg;
import com.example.sessionprovider.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/getSessionList/{id}")
    public Msg getSessionList(@PathVariable("id") Integer id){
        return sessionService.getSessionById(id);
    }

    @GetMapping("/getSessionListById/{id}")
    public Msg getSessionListById(@PathVariable("id") Integer id){
        return sessionService.getSessionBySessionId(id);
    }


    @GetMapping("/")
    public Msg getSession(){
        return Msg.success().addData("msg",sessionService.list());
    }

    @PostMapping("/addSession")
    public Msg addSession(@RequestBody Session session){
        sessionService.save(session);
        return Msg.success("添加成功");
    }

    @GetMapping("/delSession/{id}")
    public Msg delSession(@PathVariable("id") Integer id){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sessionid",id);
        sessionService.remove(queryWrapper);
        return Msg.success("删除成功");
    }
}
