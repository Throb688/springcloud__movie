package com.example.movieconsumer.controller;


import com.example.hzscommon.Dto.MovieDto;
import com.example.hzscommon.Entity.Movie;
import com.example.hzscommon.uitl.Msg;
import com.example.movieconsumer.feign.MovieFeignService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/movieconsumer")
public class MovieConsumerService {

    @Autowired
    MovieFeignService movieFeignService;

    @GetMapping("/")
    public Msg getAll(){
        return movieFeignService.getAll();
    }


    @GetMapping("/getMovieListById/{id}")
    private Msg getMovieListById(@PathVariable("id") Integer id){
        return movieFeignService.getMovieListById(id);
    }

    @GetMapping("/findMovie/{name}")
    public Msg findMovie(@PathVariable("name") String name){
        return movieFeignService.findMovie(name);
    }


    @PostMapping("/user/uploadTest1")
    public Msg uploadTest1(
            @RequestPart("photoRef") MultipartFile photoRef
    ){
        try {
            // 获取原始文件名和文件扩展名
            String originalFilename = photoRef.getOriginalFilename();
            String fileExtension = FilenameUtils.getExtension(originalFilename);

            // 生成新的文件名
            String newFileName = UUID.randomUUID().toString() + "." + fileExtension;

            // 确定本地资源文件夹的路径// 确定本地资源文件夹的路径
            String resourceFolderPath = "D:\\JAVA\\2023\\exma\\hzs-consumer\\MovieConsumer\\src\\main\\resources\\static\\img\\";

            // 创建目标文件对象
            File targetFile = new File(resourceFolderPath + newFileName);


            // 将上传的文件保存到目标文件中
            photoRef.transferTo(targetFile);


            return Msg.success("上传成功").addData("fileName",targetFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
            return Msg.fail("上传失败");
        }
    }


    @PostMapping("/addMovie")
    public Msg addMovie(@RequestBody MovieDto movieDto){
        return movieFeignService.addMovie(movieDto);
    }

    @GetMapping("/delMovie/{id}")
    public Msg delMovie(@PathVariable("id")Integer movieId) {
        return movieFeignService.delMovie(movieId);
    }

    @PostMapping("/updateMovie")
    public Msg updateMovie(@RequestBody Movie movie){
        return movieFeignService.updateMovie(movie);
    }



}
