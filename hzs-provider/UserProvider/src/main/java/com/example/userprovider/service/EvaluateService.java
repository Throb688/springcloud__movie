package com.example.userprovider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hzscommon.Dto.EvaluateDto;
import com.example.hzscommon.Dto.UserDto;
import com.example.hzscommon.Entity.Evaluate;
import com.example.hzscommon.Entity.User;
import com.example.hzscommon.uitl.Msg;


public interface EvaluateService extends IService<Evaluate> {
     Msg addEvaluate(EvaluateDto evaluateDto);
     Msg findEvaluate(Integer movie);
}
