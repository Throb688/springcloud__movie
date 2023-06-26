package com.example.sessionprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hzscommon.Entity.Session;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionMapper extends BaseMapper<Session> {
}
