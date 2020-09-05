package com.helloxin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yebanxian on 2020/8/11.
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Override
    @Transactional(rollbackFor= Exception.class)
    public void doSomeing(List<String> goodsIds) {
        log.info("doSomeing");
//        for(String goodsId:goodsIds){
//            log.info("goodsId={}",goodsId);
//            if(goodsId.equals("xin")){
//               throw new RuntimeException("wrong");
//            }
//            log.info("goodsId={} end",goodsId);
//        }
        goodsIds.stream().forEach(goodsId->{
            log.info("goodsId={}",goodsId);
            if(goodsId.equals("xin")){
               throw new RuntimeException("wrong");
            }
            log.info("goodsId={} end",goodsId);
        });
        log.info("I am the end");
    }
}
