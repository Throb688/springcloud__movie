package com.example.orderprovider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.Entity.Order;
import com.example.hzscommon.uitl.Msg;
import com.example.orderprovider.mapper.OrderMapper;

public interface OrderService extends IService<Order> {

    Msg addOrder(OrderDto orderDto);

    Msg findSessionById(Integer sessionid);

    Msg findOrderByUserId(Integer sessionid);
}
