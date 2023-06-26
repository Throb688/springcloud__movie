package com.example.seatprovide.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hzscommon.Entity.Seat;
import com.example.hzscommon.uitl.Msg;
import com.example.seatprovide.mapper.SeatMapper;
import com.example.seatprovide.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat> implements SeatService {

    @Autowired
    SeatMapper seatMapper;

    public Msg getSeatListById(List<String> ids){
        return Msg.success().addData("msg", seatMapper.selectBatchIds(ids));
    }

}
