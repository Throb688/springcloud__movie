package com.example.seatconsumer.controller;


import com.example.hzscommon.uitl.Msg;
import com.example.seatconsumer.feign.SeatFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seatconsumer")
public class SeatConsumerService {

    @Autowired
    SeatFeignService seatFeignService;

    @GetMapping("/getSeatList")
    private Msg getSeatList(){
        return seatFeignService.getSeatList();
    }

    @GetMapping("/getSeatListById/{id}")
    private Msg getSeatListById(@PathVariable("id") List<String> ids){
        return seatFeignService.getSeatListById(ids);
    }
}
