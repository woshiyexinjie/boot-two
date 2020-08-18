package com.helloxin.restful.api.bo;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yebanxian on 2020/8/11.
 */
@Data
@Builder
public class SkuStockBO {
    Long skuId;
    String skuName;
    String describtion;
}
