package com.example.hzsfeign.Clients;


import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.impl.OrderClientsServiceImpl;
import com.example.hzsfeign.Clients.impl.UserClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OrderService",path = "/order",fallback = OrderClientsServiceImpl.class)
public interface OrderClients {

    @PostMapping("/addOrder")
    Msg addOrder(@RequestBody OrderDto orderDto);


    @GetMapping("/findSessionById/{id}")
    Msg findSessionById(@PathVariable("id") Integer sessionid);

    @GetMapping("/findOrderByUserId/{userid}")
    Msg findOrderByUserId(@PathVariable("userid") Integer userid);

    @GetMapping("/")
     Msg orderList();
}
