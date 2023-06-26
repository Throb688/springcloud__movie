package com.example.hzscommon.Entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Vo.MovieVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("movie")
public class Movie {
    private Integer movieid;
    private String title;
    private String director;
    private String actors;
    private String releasedate;
    private String description;
    private String genres;
    private int durationminutes;
    private String posterurl;
    private String duration;
    private String price;


    public Movie(String title, String director, String actors, String releasedate, String description, String genres, int durationminutes, String posterurl, String duration, String price) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.releasedate = releasedate;
        this.description = description;
        this.genres = genres;
        this.durationminutes = durationminutes;
        this.posterurl = posterurl;
        this.duration = duration;
        this.price = price;
    }

    public static Movie fromMovie(MovieDto movie) {
        return new Movie(
                movie.getTitle(), movie.getDirector(),
                movie.getActors(),movie.getReleasedate(),movie.getDescription(),movie.getGenres(),movie.getDurationminutes(),
               movie.getPosterurl(),movie.getDuration(),movie.getPrice()
        );
    }

}
