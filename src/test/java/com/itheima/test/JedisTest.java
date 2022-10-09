package com.itheima.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //1.建立连接
        jedis=new Jedis("192.168.234.134",6379);
        //2、设置密码
        jedis.auth("123321");
        //3、选择库
        jedis.select(0);


    }
    @Test
    void testjedis(){
        //存入数据
        String result = jedis.set("name", "胡歌");
        System.out.println("result=="+result);
        //获取数据
        String name = jedis.get("name");
        System.out.println("name=="+name);


    }
    @AfterEach
    void tearDown(){
        if (jedis!=null){
            jedis.close();
        }
    }

}
