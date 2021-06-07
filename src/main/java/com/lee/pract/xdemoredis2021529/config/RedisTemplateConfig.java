package com.lee.pract.xdemoredis2021529.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplateConfig {

        @Bean //redisTemplate注入到Spring容器
        public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
            RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
            RedisSerializer<String> redisSerializer = new StringRedisSerializer();
            redisTemplate.setConnectionFactory(factory);
            //key序列化
            redisTemplate.setKeySerializer(redisSerializer);
            //value序列化
            redisTemplate.setValueSerializer(redisSerializer);
            //value hashmap序列化
            redisTemplate.setHashKeySerializer(redisSerializer);
            //key hashmap序列化
            redisTemplate.setHashValueSerializer(redisSerializer);
            return redisTemplate;
        }

}
