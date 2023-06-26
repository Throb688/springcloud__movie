package com.example.hzsfeign.Clients.impl;

import com.example.hzscommon.Entity.Session;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.SessionClients;

public class SessionClientsImpl implements SessionClients {
    @Override
    public Msg getSessionList(Integer id) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg getSessionListById(Integer id) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg getSession() {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg addSession(Session session) {
        return  Msg.fail("服务不可用");
    }

    @Override
    public Msg delSession(Integer id) {
        return Msg.fail("服务不可用");
    }
}
