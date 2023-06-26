package com.example.hzsfeign.Clients.impl;

import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.MovieClients;
import org.springframework.web.multipart.MultipartFile;

public class MovieClientsServiceImpl implements MovieClients {
    @Override
    public Msg getAll() {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg getMovieListById(Integer id) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg findMovie(String name) {
        return Msg.fail("服务不可用");
    }

    @Override
    public Msg addMovie(MovieDto movieDto) {
        return  Msg.fail("服务不可用");
    }

    @Override
    public Msg delMovie(Integer movieId) {
        return  Msg.fail("服务不可用");
    }

    @Override
    public Msg updateMovie(Movie movie) {
        return  Msg.fail("服务不可用");
    }


}
