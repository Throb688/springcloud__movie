package com.example.hzsfeign.Clients;


import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.impl.SeatClientsServiceImpl;
import com.example.hzsfeign.Clients.impl.UserClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "SeatService",path = "/seat",fallback = SeatClientsServiceImpl.class)
public interface SeatClients {

    @GetMapping("/getSeatList")
    Msg getSeatList();

    @GetMapping("/getSeatListById/{id}")
   Msg getSeatListById(@PathVariable("id") List<String> ids);
}
