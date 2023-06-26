package com.example.userconsumer.feign;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        // 配置缓存名称及其对应的配置，可以根据需要添加多个缓存
        cacheManager.setCacheNames(Arrays.asList("cacheName1", "cacheName2"));
        // 设置缓存的配置参数
        cacheManager.setCaffeine(Caffeine.newBuilder().maximumSize(100));
        return cacheManager;
    }
}
