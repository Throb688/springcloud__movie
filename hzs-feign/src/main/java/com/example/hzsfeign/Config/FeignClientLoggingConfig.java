package com.example.hzsfeign.Config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientLoggingConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // 设置日志级别为FULL，打印请求和响应的详细信息
    }
}
