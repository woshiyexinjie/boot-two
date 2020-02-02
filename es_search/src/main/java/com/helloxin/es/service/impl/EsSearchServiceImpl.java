package com.helloxin.es.service.impl;

import com.alibaba.fastjson.JSON;
import com.helloxin.es.document.ProductDocument;
import com.helloxin.es.repository.ProductDocumentRepository;
import com.helloxin.es.service.EsSearchService;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.matchPhraseQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

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
        log.info("【保存索引】：{}", JSON.toJSONString(productDocumentRepository.saveAll(Arrays.asList(productDocuments))));
//        }
    }

    @Override
    public ProductDocument queryOrder(String query) {
        Optional<ProductDocument> byId = productDocumentRepository.findById(query);
        return byId.orElse(new ProductDocument());
    }

    @Override
    public void deleteById(String id) {
        productDocumentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        productDocumentRepository.deleteAll();
    }

    @Override
    public List<ProductDocument> queryOrderbDate(Date begin, Date end) {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()..build();
//        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
        return null;
    }

    @Override
    public List<ProductDocument> singleTitle(String word, Pageable pageable) {
        //使用queryStringQuery完成单字符串查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> singleMatch(String productName, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("productName", productName)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> singlePhraseMatch(String productDesc, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchPhraseQuery("productDesc", productDesc).slop(2)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> singleTerm(String productName, Pageable pageable) {
        //不对传来的值分词，去找完全匹配的
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("productName", productName)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> contain(String productName, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("productName", productName).operator(Operator.AND)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> rangeQuery(Long begin, Long end, Pageable pageable) {
        QueryBuilder queryBuilder = QueryBuilders.rangeQuery("createTime")
                .from(begin)
                .to(end)
                .includeLower(true)     // 包含上界
                .includeUpper(true);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> singleMatchJson(String goodsName, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("goods.name", goodsName)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> rangeQueryJson(Long begin, Long end, Pageable pageable) {
        QueryBuilder queryBuilder = QueryBuilders.rangeQuery("goods.uptime")
                .from(begin)
                .to(end)
                .includeLower(true)     // 包含上界
                .includeUpper(true);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }

    @Override
    public List<ProductDocument> multiQueryJson(String goodsName, Long begin, Long end, Pageable pageable) {
        MatchPhraseQueryBuilder q1 = QueryBuilders.matchPhraseQuery("goods.name", goodsName);
        RangeQueryBuilder q2 = QueryBuilders.rangeQuery("goods.uptime")
                .from(begin)
                .to(end)
                .includeLower(true)
                .includeUpper(true);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.boolQuery().must(q1).filter(q2)).withPageable(pageable).build();
        return elasticsearchTemplate.queryForList(searchQuery, ProductDocument.class);
    }


}
