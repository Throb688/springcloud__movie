package com.example.sessionconsumer;

import com.example.hzsfeign.Clients.SessionClients;
import com.example.hzsfeign.Clients.UserClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableFeignClients(clients = SessionClients.class)
public class SessionConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionConsumerApplication.class, args);
    }

}
