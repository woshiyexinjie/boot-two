package com.helloxin.es.document;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "orders", type = "product")
//@Mapping(mappingPath = "productIndex.json") // 解决IK分词不能使用问题
public class ProductDocument implements Serializable {

    @Id
    private String id;
//    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String productName;
//    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String productDesc;

    private Date createTime;

    private Date updateTime;

    private JSONObject goods;

    public JSONObject getGoods() {
        return goods;
    }

    public void setGoods(JSONObject goods) {
        this.goods = goods;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductDocument{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", goods=" + goods +
                '}';
    }
}
