package com.helloxin.mybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.helloxin.mybaits.dao.vo.User;
import com.helloxin.mybatis.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ApplicationTests {
	
	
	final static Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	@Commit
	public void findByName() throws Exception {
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");

		logger.info("find user={}",u.getName());
//		Assert.assertEquals(20, u.getAge().intValue());
	}

}
