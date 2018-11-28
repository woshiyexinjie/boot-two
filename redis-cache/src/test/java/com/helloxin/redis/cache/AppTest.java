package com.helloxin.redis.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

	@Test
	public void cacheTst() {
		
		logger.info("cache Test");
		String key = "helloxin";
		String value = "lucky";
		RedisConnection connection = redisConnectionFactory.getConnection();
        try {
            boolean result = connection.set(key.getBytes(), value.getBytes());
            logger.info("cache Test result={}",result);
            byte[] bytes = connection.get(key.getBytes());
            logger.info("cache test get string={}",new String(bytes));
            Long delresult = connection.del(key.getBytes());
            logger.info("cache test del long={}",delresult);

        }finally {
            if (connection != null)
                connection.close();
        }

	}
	

}