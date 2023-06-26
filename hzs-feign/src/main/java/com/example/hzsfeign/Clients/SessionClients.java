package com.example.hzsfeign.Clients;


import com.example.hzscommon.Entity.Session;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.impl.SeatClientsServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SessionService",path = "/session",fallback = SeatClientsServiceImpl.class)
public interface SessionClients {

    @GetMapping("/getSessionList/{id}")
    Msg getSessionList(@PathVariable("id") Integer id);

    @GetMapping("/getSessionListById/{id}")
   Msg getSessionListById(@PathVariable("id") Integer id);

    @GetMapping("/")
    Msg getSession();

    @PostMapping("/addSession")
     Msg addSession(@RequestBody Session session);

    @GetMapping("/delSession/{id}")
     Msg delSession(@PathVariable("id") Integer id);
}
