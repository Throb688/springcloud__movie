package com.example.movieprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.Vo.MovieVo;
import com.example.hzscommon.uitl.Msg;
import com.example.movieprovider.mapper.MovieMapper;
import com.example.movieprovider.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Autowired
     MovieMapper movieMapper;

    @Override
    public Msg getMovieById(Integer id) {
        QueryWrapper wq = new QueryWrapper<>();
        wq.eq("movieid",id);
        Movie movie =  movieMapper.selectOne(wq);
        return Msg.success().addData("mes",movie);
    }

    @Override
    public Msg findMovie(String name) {
        QueryWrapper wq = new QueryWrapper<>();
        wq.like("title",name);
        List<Movie> list = movieMapper.selectList(wq);
        List<MovieVo> list1 = new ArrayList<>();
        for (Movie  movie: list) {
            System.out.println(movie);
            list1.add(MovieVo.fromMovie(movie));
        }
        return Msg.success().addData("msg",list1);
    }

    public Msg addMovie(MovieDto movieDto){
        Movie movie = Movie.fromMovie(movieDto);
        int flag = movieMapper.insert(movie);
        if(flag==1) return Msg.success("添加成功");
        return Msg.fail("新增失败");
    }

    public Msg delMovie(Integer movieId){
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("movieId",movieId);
        movieMapper.delete(qw);
       return Msg.success("删除成功");

    }

    public Msg updateMovie(Movie movie){
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("movieId",movie.getMovieid());
        int flag = movieMapper.update(movie,qw);
        if(flag==1) return Msg.success("更新成功");
        return Msg.fail("更新失败");
    }


}
