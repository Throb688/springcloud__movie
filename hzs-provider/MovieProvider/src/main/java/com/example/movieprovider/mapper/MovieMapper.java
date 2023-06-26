package com.example.movieprovider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hzscommon.Entity.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieMapper extends BaseMapper<Movie> {
}
