package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.GoodsBO;

/**
 * Created by yebanxian on 2020/8/11.
 */
public interface GoodsService {
    GoodsBO getGoodsInfoByGoodsId(Long goodsId);
}
