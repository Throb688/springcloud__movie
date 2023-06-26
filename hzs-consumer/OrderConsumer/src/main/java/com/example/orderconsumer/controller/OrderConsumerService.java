package com.example.orderconsumer.controller;


import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.uitl.Msg;
import com.example.orderconsumer.feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderconsumer")
public class OrderConsumerService {

    @Autowired
    OrderFeignService orderFeignService;

    @PostMapping("/addOrder")
    public Msg addOrder(@RequestBody OrderDto orderDto){
        return  orderFeignService.addOrder(orderDto);
    }

    @GetMapping("/findSessionById/{id}")
    public Msg findSessionById(@PathVariable("id") Integer sessionid){
        return orderFeignService.findSessionById(sessionid);
    }
    @GetMapping("/findOrderByUserId/{userid}")
    public Msg findOrderByUserId(@PathVariable("userid") Integer userid){
        return orderFeignService.findOrderByUserId(userid);
    }

    @GetMapping("/")
    public Msg orderList(){
        return orderFeignService.orderList();
    }
}
