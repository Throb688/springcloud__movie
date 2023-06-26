package com.example.movieprovider.controller;


import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.uitl.Msg;
import com.example.movieprovider.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/getAll")
    public Msg getAll(){
        return Msg.success().addData("mes",movieService.list());
    }

    @GetMapping("/getMovieListById/{id}")
    private Msg getMovieListById(@PathVariable("id") Integer id){
        return movieService.getMovieById(id);
    }


    @GetMapping("/findMovie/{name}")
    public Msg findMovie(@PathVariable("name") String name){
        return movieService.findMovie(name);
    }

    @PostMapping("/addMovie")
    public Msg addMovie(@RequestBody MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }

    @GetMapping("/delMovie/{id}")
    public Msg delMovie(@PathVariable("id") Integer movieId) {
        return movieService.delMovie(movieId);
    }

    @PostMapping("/updateMovie")
    public Msg updateMovie(@RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }



}
