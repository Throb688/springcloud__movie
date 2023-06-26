package com.example.orderprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hzscommon.Entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
