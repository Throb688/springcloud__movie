package com.example.movieconsumer;

import com.example.hzsfeign.Clients.MovieClients;
import com.example.hzsfeign.Clients.UserClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableFeignClients(clients = MovieClients.class)
public class MovieConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieConsumerApplication.class, args);
    }

}
