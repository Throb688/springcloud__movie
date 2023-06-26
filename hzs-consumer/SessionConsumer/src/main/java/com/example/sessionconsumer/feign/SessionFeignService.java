package com.example.sessionconsumer.feign;


import com.example.hzscommon.Entity.Session;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.SessionClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(name = "SessionService",path = "/session")
public class SessionFeignService implements SessionClients {

    @Autowired
    SessionClients sessionClients;
    @Override
    public Msg getSessionList(Integer id) {
        return sessionClients.getSessionList(id);
    }

    @Override
    public Msg getSessionListById(Integer id) {
        return sessionClients.getSessionListById(id);
    }

    @Override
    public Msg getSession() {
        return sessionClients.getSession();
    }

    @Override
    public Msg addSession(Session session) {
        return sessionClients.addSession(session);
    }

    @Override
    public Msg delSession(Integer id) {
        return sessionClients.delSession(id);
    }
}
