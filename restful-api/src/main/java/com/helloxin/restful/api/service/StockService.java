package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.SkuStockBO;

/**
 * Created by yebanxian on 2020/8/11.
 */
public interface StockService {
    SkuStockBO getSkuStockBySkuId(Long skuId);
}
