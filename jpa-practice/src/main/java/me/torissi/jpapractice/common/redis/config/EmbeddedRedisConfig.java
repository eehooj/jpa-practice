package me.torissi.jpapractice.common.redis.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

@Configuration
@RequiredArgsConstructor
public class EmbeddedRedisConfig {

  private final RedisProperties redisProperties;
  private RedisServer redisServer;

  @PostConstruct
  public void redisServer() {
    redisServer = RedisServer
        .builder()
        .port(redisProperties.getPort())
        .setting("maxheap 512MB")
        .build();
    redisServer.start();
  }

  @PreDestroy
  public void stopRedis() {
    if (redisServer != null) {
      redisServer.stop();
    }
  }

}
