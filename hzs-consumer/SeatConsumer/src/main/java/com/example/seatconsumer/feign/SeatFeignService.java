package com.example.seatconsumer.feign;

import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.SeatClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@FeignClient(name = "SeatService",path = "/seat")
public class SeatFeignService implements SeatClients {

    @Autowired
    SeatClients seatClients;
    @Override
    public Msg getSeatList() {
        return seatClients.getSeatList();
    }

    @Override
    public Msg getSeatListById(List<String> ids) {
        return seatClients.getSeatListById(ids);
    }
}
