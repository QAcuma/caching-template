package org.example.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

@Configuration
@EnableCaching
public class RedissonCacheConfig {

    @Bean(destroyMethod = "shutdown")
    RedissonClient redisson(@Value("classpath:/${redisson.config}") Resource configFile) throws IOException {
        Config config = Config.fromYAML(configFile.getInputStream());

        return Redisson.create(config);
    }

    @Bean
    CacheManager redissonCacheManager(RedissonClient redissonClient) {
        var cacheConfig = Map.of(
                "CATS", new CacheConfig(300_000, 150_000)
        );

        return new RedissonSpringCacheManager(redissonClient, cacheConfig);
    }
}
