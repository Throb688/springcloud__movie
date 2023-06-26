package com.example.hzsfeign.Clients.impl;

import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.SeatClients;
import com.example.hzsfeign.Clients.SessionClients;

import java.util.List;

public class SeatClientsServiceImpl implements SeatClients {

    @Override
    public Msg getSeatList() {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg getSeatListById(List<String> ids) {
        return Msg.fail("服务不可用");
    }
}
