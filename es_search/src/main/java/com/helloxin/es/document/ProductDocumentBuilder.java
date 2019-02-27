package com.helloxin.es.document;

import java.util.Date;

public class ProductDocumentBuilder {
    private static ProductDocument productDocument;

    // create start
    public static ProductDocumentBuilder create(){
        productDocument = new ProductDocument();
        return new ProductDocumentBuilder();
    }
    public ProductDocumentBuilder addId(String id) {
        productDocument.setId(id);
        return this;
    }

    public ProductDocumentBuilder addProductName(String productName) {
        productDocument.setProductName(productName);
        return this;
    }

    public ProductDocumentBuilder addProductDesc(String productDesc) {
        productDocument.setProductDesc(productDesc);
        return this;
    }

    public ProductDocumentBuilder addCreateTime(Date createTime) {
        productDocument.setCreateTime(createTime);
        return this;
    }

    public ProductDocumentBuilder addUpdateTime(Date updateTime) {
        productDocument.setUpdateTime(updateTime);
        return this;
    }

    public ProductDocument builder() {
        return productDocument;
    }
}
