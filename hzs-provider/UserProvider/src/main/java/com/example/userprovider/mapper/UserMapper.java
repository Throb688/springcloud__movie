package com.example.userprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hzscommon.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
