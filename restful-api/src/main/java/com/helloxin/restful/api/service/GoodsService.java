package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.GoodsBO;

import java.util.List;

/**
 * Created by yebanxian on 2020/8/11.
 */
public interface GoodsService {
    GoodsBO getGoodsInfoByGoodsId(Long goodsId);

    void doSomeing(List<String> goodsIds);
}
