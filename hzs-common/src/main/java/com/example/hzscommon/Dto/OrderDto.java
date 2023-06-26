package com.example.hzscommon.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderid;
    private int sessionid;
    private String[] seatidInfo;
    private String seatInfo;
    private double price;
    private int userid;
}
