package com.example.hzsfeign.Clients;


import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.uitl.Msg;
import com.example.hzsfeign.Clients.impl.UserClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "MovieService",path = "/movie",fallback = UserClientServiceImpl.class)
public interface MovieClients {

    @GetMapping("/getAll")
    Msg getAll();

    @GetMapping("/getMovieListById/{id}")
    Msg getMovieListById(@PathVariable("id") Integer id);

    @GetMapping("/findMovie/{name}")
    Msg findMovie(@PathVariable("name") String name);


    @PostMapping("/addMovie")
    public Msg addMovie(@RequestBody MovieDto movieDto);

    @GetMapping("/delMovie/{id}")
    public Msg delMovie(@PathVariable("id")Integer movieId) ;

    @PostMapping("/updateMovie")
    public Msg updateMovie(@RequestBody Movie movie);


}
