package com.example.sessionprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hzscommon.Entity.Session;
import com.example.hzscommon.uitl.Msg;
import com.example.sessionprovider.mapper.SessionMapper;
import com.example.sessionprovider.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl extends ServiceImpl<SessionMapper, Session> implements SessionService {

    @Autowired
     SessionMapper sessionMapper;
    @Override
    public Msg getSessionById(Integer id) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("movieid",id);
        return Msg.success().addData("msg",sessionMapper.selectList(qw));
    }

    @Override
    public Msg getSessionBySessionId(Integer id) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("sessionid",id);
        return Msg.success().addData("msg",sessionMapper.selectList(qw));
    }
}