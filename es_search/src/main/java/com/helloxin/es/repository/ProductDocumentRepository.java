package com.helloxin.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.helloxin.es.document.ProductDocument;

@Component
public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument,String> {
}
