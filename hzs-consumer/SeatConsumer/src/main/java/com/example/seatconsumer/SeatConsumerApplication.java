package com.example.seatconsumer;

import com.example.hzsfeign.Clients.SeatClients;
import com.example.hzsfeign.Clients.SessionClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableFeignClients(clients = SeatClients.class)
public class SeatConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeatConsumerApplication.class, args);
    }

}
