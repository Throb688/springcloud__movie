package com.example.movieconsumer.feign;

import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.MovieClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@FeignClient(name = "MovieService",path = "/movie")
public class MovieFeignService implements MovieClients{

    @Autowired
    MovieClients movieClients;


    @Override
    public Msg getAll() {
        return movieClients.getAll();
    }

    @Override
    public Msg getMovieListById(Integer id) {
        return movieClients.getMovieListById(id);
    }

    @Override
    public Msg findMovie(String name) {
        return movieClients.findMovie(name);
    }

    @Override
    public Msg addMovie(MovieDto movieDto) {
        return movieClients.addMovie(movieDto);
    }

    @Override
    public Msg delMovie(Integer movieId) {
        return movieClients.delMovie(movieId);
    }

    @Override
    public Msg updateMovie(Movie movie) {
        return movieClients.updateMovie(movie);
    }


}
