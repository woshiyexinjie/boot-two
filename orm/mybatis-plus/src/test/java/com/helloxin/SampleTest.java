package com.helloxin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.helloxin.data.User;
import com.helloxin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setName("pigHead");
        user.setAge(1);
        user.setEmail("hello@gmail.com");
        int num = userMapper.insert(user);

        User pigHead = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getName, "pigHead"));
        log.info(pigHead.toString());
    }

}
