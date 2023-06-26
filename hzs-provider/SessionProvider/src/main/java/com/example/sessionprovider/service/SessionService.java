package com.example.sessionprovider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hzscommon.Entity.Session;
import com.example.hzscommon.uitl.Msg;

public interface SessionService extends IService<Session> {
    Msg getSessionById(Integer id);

    Msg getSessionBySessionId(Integer id);
}
