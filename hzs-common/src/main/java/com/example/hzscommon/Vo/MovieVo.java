package com.example.hzscommon.Vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.hzscommon.Dto.OrderDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieVo {

    private String movieid;
    private String title;
    private String director;
    private String genres;
    private String posterurl;
    private String duration;
    private String price;


    public static MovieVo fromMovie(Movie movie) {
        return new MovieVo(
                movie.getMovieid().toString(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getGenres(),
                movie.getPosterurl(),
                movie.getDuration(),
                movie.getPrice()
                );
    }

}
