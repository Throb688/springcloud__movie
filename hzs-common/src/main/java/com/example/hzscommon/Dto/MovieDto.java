package com.example.hzscommon.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private String movieid;
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
}
