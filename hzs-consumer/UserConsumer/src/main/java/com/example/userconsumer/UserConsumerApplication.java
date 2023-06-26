package com.example.userconsumer;

import com.example.hzsfeign.Clients.UserClients;
import com.example.hzsfeign.Config.FeignClientLoggingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableFeignClients(clients = UserClients.class)
public class UserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);
    }

}
