package com.helloxin.es.service.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.helloxin.es.document.ProductDocument;
import com.helloxin.es.repository.ProductDocumentRepository;
import com.helloxin.es.service.EsSearchService;

@Service
public class EsSearchServiceImpl implements EsSearchService {
	
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
	private ProductDocumentRepository productDocumentRepository;

	@Override
	public void save(ProductDocument... productDocuments) {
		// TODO Auto-generated method stub
		elasticsearchTemplate.putMapping(ProductDocument.class);
//        if(productDocuments.length > 0){
//            /*Arrays.asList(productDocuments).parallelStream()
//                    .map(productDocumentRepository::save)
//                    .forEach(productDocument -> log.info("【保存数据】：{}", JSON.toJSONString(productDocument)));*/
            log.info("【保存索引】：{}",JSON.toJSONString(productDocumentRepository.saveAll(Arrays.asList(productDocuments))));
//        }
	}

}
