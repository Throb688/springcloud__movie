package com.example.movieprovider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.uitl.Msg;
import com.example.movieprovider.mapper.MovieMapper;

public interface MovieService extends IService<Movie> {

    Msg getMovieById(Integer id);
    Msg findMovie(String name);
    Msg addMovie(MovieDto movieDto);
    Msg delMovie(Integer movieId);
    Msg updateMovie(Movie movie);
}
