package com.example.seatprovide.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hzscommon.Entity.Seat;
import com.example.hzscommon.uitl.Msg;

import java.util.List;

public interface SeatService extends IService<Seat> {
    Msg getSeatListById(List<String> ids);

}
