package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.SkuStockBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by yebanxian on 2020/8/11.
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService{
    @Override
    public SkuStockBO getSkuStockBySkuId(Long skuId) {
        log.info("skuId ={}", skuId);
        return SkuStockBO.builder().skuId(skuId)
                .skuName("shufujia-san-yellow")
                .describtion("protect your skin collor yellow")
                .build();
    }
}
