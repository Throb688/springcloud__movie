package com.example.orderconsumer.feign;

import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.OrderClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(name = "OrderService",path = "/order")
public class OrderFeignService implements OrderClients {

    @Autowired
    OrderClients orderClients;
    @Override
    public Msg addOrder(OrderDto orderDto) {
        return orderClients.addOrder(orderDto);
    }

    @Override
    public Msg findSessionById(Integer sessionid) {
        return orderClients.findSessionById(sessionid);
    }

    @Override
    public Msg findOrderByUserId(Integer userid) {
        return orderClients.findOrderByUserId(userid);
    }

    @Override
    public Msg orderList() {
        return orderClients.orderList();
    }
}
