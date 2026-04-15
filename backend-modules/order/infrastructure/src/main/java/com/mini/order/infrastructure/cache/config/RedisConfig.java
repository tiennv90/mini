package com.mini.order.infrastructure.cache.config;

import java.time.Duration;
import java.util.Collections;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import tools.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		LettuceConnectionFactory factory = new LettuceConnectionFactory();
		factory.afterPropertiesSet();
		return factory;
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory)
				.cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
						.entryTtl(Duration.ofMinutes(1))
						.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
						.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))).transactionAware()
				.build();
		return cacheManager;
	}
}
