package com.helloxin.restful.api;

import com.helloxin.restful.api.bo.GoodsBO;
import com.helloxin.restful.api.bo.SkuStockBO;
import com.helloxin.restful.api.bo.UserBO;
import com.helloxin.restful.api.service.GoodsService;
import com.helloxin.restful.api.service.StockService;
import com.helloxin.restful.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class GoodsDetailTest {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private StockService stockService;
    @Autowired
    private UserService userService;

    @Test
    public void should_get_goods_info_success() {
        GoodsBO goods = goodsService.getGoodsInfoByGoodsId(123L);
        log.info(goods.toString());
        SkuStockBO skuStock = stockService.getSkuStockBySkuId(123666L);
        log.info(skuStock.toString());
        UserBO user = userService.getUserByUserId("16544");
        log.info(user.toString());
    }

    @Test
    public void should_get_goods_info_then_success() throws ExecutionException, InterruptedException {
        CompletableFuture<UserBO> future1 = CompletableFuture.supplyAsync(() -> {
               return goodsService.getGoodsInfoByGoodsId(123L);
        }).thenApply(x->{
              log.info(x.toString());
               return stockService.getSkuStockBySkuId(123666L);
        }).thenApply(y->{
               log.info(y.toString());
               return  userService.getUserByUserId("16544");
        });
        System.out.println(future1.get());
    }

    @Test
    public void should_get_goods_info_sync_success() throws ExecutionException, InterruptedException {
        CompletableFuture<GoodsBO> goods = CompletableFuture.supplyAsync(() -> {
               return goodsService.getGoodsInfoByGoodsId(123L);
        });

        CompletableFuture<SkuStockBO> skuStock = CompletableFuture.supplyAsync(() -> {
            return stockService.getSkuStockBySkuId(123666L);
        });

        CompletableFuture<UserBO> user = CompletableFuture.supplyAsync(() -> {
            return userService.getUserByUserId("16544");
        });

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(goods, skuStock, user);
//        completableFuture.get();
        completableFuture.join();
        log.info(goods.get().toString());
        log.info(skuStock.get().toString());
        log.info(user.get().toString());
    }

    @Test
    public void should_get_goods_info_allof_success() throws ExecutionException, InterruptedException {
        CompletableFuture<GoodsBO> goods = CompletableFuture.supplyAsync(() -> {
            return goodsService.getGoodsInfoByGoodsId(123L);
        });

        CompletableFuture<SkuStockBO> skuStock = CompletableFuture.supplyAsync(() -> {
            return stockService.getSkuStockBySkuId(123666L);
        });

        CompletableFuture<UserBO> user = CompletableFuture.supplyAsync(() -> {
            return userService.getUserByUserId("16544");
        });

        List<Object> collect = Stream.of(goods, skuStock, user).map(CompletableFuture::join).collect(Collectors.toList());
        for (Object object:collect){
            if(object instanceof  GoodsBO){
                log.info("goodsId ={}",((GoodsBO) object).getGoodsId());
            }
            if(object instanceof  SkuStockBO){
                log.info("skuId ={}",((SkuStockBO) object).getSkuId());
            }
            if(object instanceof  UserBO){
                log.info("userId ={}",((UserBO) object).getUserId());
            }
        }

    }


    @Test
    public void should_complete_future_success() {
        CompletableFuture<UserBO>cf = CompletableFuture.completedFuture(userService.getUserByUserId("16544"));
        assertTrue(cf.isDone());
        assertEquals("16544", cf.getNow(null).getUserId());
    }




}
