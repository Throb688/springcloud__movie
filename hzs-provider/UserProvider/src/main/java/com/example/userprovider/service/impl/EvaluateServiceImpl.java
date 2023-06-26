package com.example.userprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hzscommon.Dto.EvaluateDto;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.Entity.Evaluate;
import com.example.hzscommon.Entity.User;
import com.example.hzscommon.uitl.Msg;
import com.example.hzscommon.uitl.PasswordUtils;
import com.example.userprovider.mapper.EvaluateMapper;
import com.example.userprovider.mapper.UserMapper;
import com.example.userprovider.service.EvaluateService;
import com.example.userprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements EvaluateService {

    @Autowired
    EvaluateMapper evaluateMapper;

    @Autowired
    UserMapper userMapper;


    public Msg addEvaluate(EvaluateDto evaluateDto){
        User user= userMapper.selectById(evaluateDto.getUserid());
        Evaluate evaluate = new Evaluate();
        evaluate.setUsername(user.getUsername());
        evaluate.setMovieid(evaluateDto.getMovieId());
        evaluate.setEvaluatetext(evaluateDto.getEvaluatetext());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        evaluate.setEvaluatetime(formattedDateTime);
        evaluateMapper.insert(evaluate);
        return Msg.success();
    }

    @Override
    public Msg findEvaluate(Integer movie) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("movieid",movie);
        return Msg.success().addData("mes", evaluateMapper.selectList(qw));
    }

}
