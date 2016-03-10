package com.heimschild.talks.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ListsTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    ListOperations<String, String> listListOperations;

    private static final String MY_LIST = "MY_LIST";

    @Before
    public void setUp() {
        listListOperations.leftPush(MY_LIST, "item-1");
        listListOperations.leftPush(MY_LIST, "item-2");
        listListOperations.leftPush(MY_LIST, "item-3");
    }

    @Test
    public void listSizeTest() {
        assertThat(listListOperations.range(MY_LIST, 0, -1).size()).isEqualTo(3);
    }

    @Test
    public void appendingTest() {
        listListOperations.rightPush(MY_LIST, "item-4");

        assertThat(listListOperations.range(MY_LIST, 0, -1).size()).isEqualTo(4);
        assertThat(listListOperations.rightPop(MY_LIST)).isEqualTo("item-4");
    }

    @Test
    public void insertingTest() {
        listListOperations.leftPush(MY_LIST, "item-0");

        assertThat(listListOperations.range(MY_LIST, 0, -1).size()).isEqualTo(4);
        assertThat(listListOperations.leftPop(MY_LIST)).isEqualTo("item-0");
    }

    @After
    public void tearDown() {
        redisTemplate.delete(MY_LIST);
    }
}
