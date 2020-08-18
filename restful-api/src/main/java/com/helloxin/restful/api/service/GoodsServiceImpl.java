package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.GoodsBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
