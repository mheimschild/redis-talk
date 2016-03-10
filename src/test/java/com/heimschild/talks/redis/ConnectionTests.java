package com.heimschild.talks.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ConnectionTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void mustCreateTemplateTest() {
        assertThat(redisTemplate).isNotNull();
    }
}
