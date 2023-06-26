package com.example.orderconsumer;

import com.example.hzsfeign.Clients.OrderClients;
import com.example.hzsfeign.Clients.SeatClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableFeignClients(clients = OrderClients.class)
public class OrderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerApplication.class, args);
    }

}
