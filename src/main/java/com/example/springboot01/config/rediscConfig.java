package com.example.springboot01.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class rediscConfig {
    @Bean
    public RedisTemplate<Object, Object> MyRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws Exception {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // 设置其他的k-v的默认的序列化
        //template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        //单独设置k的序列化
        //template.setKeySerializer(new StringRedisSerializer());
//使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        RedisCacheConfiguration redisCacheConfiguration1 = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))   // 设置过期时间 10 分钟
                .prefixCacheNameWith("cache:user")      // 设置缓存前缀
                .disableCachingNullValues()                // 禁止缓存 null 值
                // 设置 key 序列化
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer))
                // 设置 value 序列化
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer));

        RedisCacheConfiguration redisCacheConfiguration2 = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .prefixCacheNameWith("cache:user")
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));
        return RedisCacheManager.builder(factory)
                .withCacheConfiguration("user",redisCacheConfiguration1)
                .withCacheConfiguration("userinfo",redisCacheConfiguration2)
                .build();
    }

}
