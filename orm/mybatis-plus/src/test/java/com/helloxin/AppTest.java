package com.helloxin;

import com.helloxin.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppTest 
{

    @Autowired
    private GoodsService goodsService;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("xin");
        goodsService.doSomeing(list);
    }
}
