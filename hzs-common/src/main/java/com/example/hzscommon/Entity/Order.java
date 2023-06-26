package com.example.hzscommon.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.hzscommon.Dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("orderinfo")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderid;
    private int sessionid;
    private String seatidinfo;
    private String seatinfo;
    private double price;
    private int userid;
    private String ordertime;

    public Order(String orderid, int sessionid, String[] seatidInfo, String seatInfo, double price, int userid) {
        this.orderid = orderid;
        this.sessionid = sessionid;
        this.seatidinfo =String.join(",", seatidInfo);
        this.seatinfo = seatInfo;
        this.price = price;
        this.userid = userid;
    }

    public static Order fromOrderDto(OrderDto orderDto) {
        return new Order(
                orderDto.getOrderid(),
                orderDto.getSessionid(),
                orderDto.getSeatidInfo(),
                orderDto.getSeatInfo(),
                orderDto.getPrice(),
                orderDto.getUserid()
        );
    }
}
