package com.example.seatprovide.controller;

import com.example.hzscommon.uitl.Msg;
import com.example.seatprovide.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getSeatList")
    private Msg getSeatList(){
        return Msg.success().addData("msg",seatService.list());
    }

    @GetMapping("/getSeatListById/{id}")
    private Msg getSeatListById(@PathVariable("id") List<String> ids){
        return Msg.success().addData("msg",seatService.getSeatListById(ids));
    }



}
