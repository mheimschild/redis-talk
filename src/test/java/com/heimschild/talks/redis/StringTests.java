package com.heimschild.talks.redis;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StringTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Integer> intValueOperations;

    @Test
    public void getSetTest() {
        valueOperations.set("value1", "myTest");
        assertThat(valueOperations.get("value1")).isEqualTo("myTest");
    }

    @Test
    public void intGetSetTest() {
        intValueOperations.set("intValue1", 1);
        assertThat(intValueOperations.get("intValue1")).isEqualTo(1);
    }

    @After
    public void tearDown() {
        redisTemplate.delete("value1");
        redisTemplate.delete("intValue1");
    }
}
