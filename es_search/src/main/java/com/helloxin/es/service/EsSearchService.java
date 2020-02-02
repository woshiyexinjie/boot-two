package com.helloxin.es.service;

import com.helloxin.es.document.ProductDocument;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface EsSearchService {
	
	void save(ProductDocument... productDocuments);

    ProductDocument queryOrder(String query);

    void deleteById(String id);

    void deleteAll();

    List<ProductDocument> queryOrderbDate(Date begin, Date end);

    List<ProductDocument> singleTitle(String word, Pageable pageable);

    List<ProductDocument> singleMatch(String productName, Pageable pageable);

    List<ProductDocument> singlePhraseMatch(String productDesc, Pageable pageable);

    List<ProductDocument> singleTerm(String productName, Pageable pageable);

    List<ProductDocument> contain(String productName, Pageable pageable);

    List<ProductDocument> rangeQuery(Long begin, Long end, Pageable pageable);

    List<ProductDocument> singleMatchJson(String goodsName, Pageable pageable);

    List<ProductDocument> rangeQueryJson(Long begin, Long end, Pageable pageable);

    List<ProductDocument> multiQueryJson(String goodsName, Long begin, Long end, Pageable pageable);
}
