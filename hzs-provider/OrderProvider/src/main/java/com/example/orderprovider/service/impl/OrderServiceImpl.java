package com.example.orderprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.Entity.Order;
import com.example.hzscommon.uitl.Msg;
import com.example.orderprovider.mapper.OrderMapper;
import com.example.orderprovider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public Msg addOrder(OrderDto orderDto) {
        Order order = Order.fromOrderDto(orderDto);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        order.setOrdertime(formattedDateTime);
        orderMapper.insert(order);
        return Msg.success("购买成功");
    }

    @Override
    public Msg findSessionById(Integer sessionid) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("sessionid",sessionid);
        List<Order> list =  orderMapper.selectList(qw);
       List<String> strings = new ArrayList<>();
        for (Order order : list) {
            String aa[] = order.getSeatidinfo().split(",");
            for(String atr :aa){
                strings.add(atr);
            }
        }
        return Msg.success().addData("msg",strings);
    }

    @Override
    public Msg findOrderByUserId(Integer sessionid) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("userid",sessionid);
        List<Order> list = orderMapper.selectList(qw);
        return Msg.success().addData("msg",list);
    }
}
