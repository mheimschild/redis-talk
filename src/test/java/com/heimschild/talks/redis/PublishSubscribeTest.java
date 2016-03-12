package com.heimschild.talks.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PublishSubscribeTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    public void sendTest() {
        redisTemplate.convertAndSend("chat", "Hello All!");
    }

    @Test
    public void sendAndReceiveTest() throws InterruptedException {
        RedisSerializer valueSerializer = redisTemplate.getValueSerializer();
        RedisSerializer stringSerializes = redisTemplate.getStringSerializer();

        ExecutorService exServ = Executors.newFixedThreadPool(1);
        exServ.submit(() -> redisConnectionFactory.getConnection().subscribe((message, bytes) -> {
            System.out.println(valueSerializer.deserialize(message.getBody()));
            System.out.println(stringSerializes.deserialize(message.getChannel()));
        }, "chat".getBytes()));

        redisTemplate.convertAndSend("chat", "Hello There!");

        exServ.shutdown();
    }
}
