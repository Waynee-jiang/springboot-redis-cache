/**
 * Copyright (C), 2018-2020, Sol-c Ltd.
 * FileName: RedisConfig
 * Author:   Wayne.Jiang
 * Date:     2020-04-27 13:43
 * Description: RedisConfig
 * History:
 * <author>                <time>            <version>          <desc>
 * Wayne.Jiang         2020-04-27 13:43         $(VERSION)          RedisConfig
 */
package com.springboottemplate.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 〈一句话功能简述〉<br>
 * 〈RedisConfig 〉
 *
 * @author Wayne.Jiang
 * @create 2020-04-27 13:43
 * @since v1.0.0
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // 设置值（value）的序列化采用Jackson2JsonRedisSerializer。
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}