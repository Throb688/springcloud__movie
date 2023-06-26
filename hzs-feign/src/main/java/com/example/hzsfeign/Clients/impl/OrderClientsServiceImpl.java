package com.example.hzsfeign.Clients.impl;

import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.OrderClients;

public class OrderClientsServiceImpl implements OrderClients {
    @Override
    public Msg addOrder(OrderDto orderDto) {
      return Msg.fail("服务不可用");
    }

    @Override
    public Msg findSessionById(Integer sessionid) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg findOrderByUserId(Integer userid) {
        return  Msg.fail("服务不可用");
    }

    @Override
    public Msg orderList() {
        return Msg.fail("服务不可用");
    }
}
