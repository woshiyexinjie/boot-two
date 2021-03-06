package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.GoodsBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yebanxian on 2020/8/11.
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Override
    public GoodsBO getGoodsInfoByGoodsId(Long goodsId) {
        log.info("goodsId ={}", goodsId);
        return GoodsBO.builder().goodsId(goodsId)
                .goodsName("shufujia")
                .describtion("protect your skin")
                .build();
    }

    @Override
    public void doSomeing(List<String> goodsIds) {
        log.info("doSomeing");
        for(String goodsId:goodsIds){
            log.info("goodsId={}",goodsId);
            if(goodsId.equals("xin")){
               throw new RuntimeException("wrong");
            }
            log.info("goodsId={} end",goodsId);
        }
        log.info("I am the end");
    }
}
