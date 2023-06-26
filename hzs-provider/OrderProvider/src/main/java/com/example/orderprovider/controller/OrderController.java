package com.example.orderprovider.controller;


import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.uitl.Msg;
import com.example.orderprovider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public Msg addOrder(@RequestBody OrderDto orderDto){
        return  orderService.addOrder(orderDto);
    }

    @GetMapping("/findSessionById/{id}")
    public Msg findSessionById(@PathVariable("id") Integer sessionid){
        return orderService.findSessionById(sessionid);
    }

    @GetMapping("/findOrderByUserId/{userid}")
    public Msg findOrderByUserId(@PathVariable("userid") Integer userid){
        return orderService.findOrderByUserId(userid);
    }

    @GetMapping("/")
    public Msg orderList(){
        return Msg.success().addData("meg",orderService.list());
    }

}
