package com.helloxin.es.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
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

    private GoodsInfo goods;
}
