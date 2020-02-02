package com.helloxin.es;

import com.helloxin.es.document.ProductDocument;
import com.helloxin.es.service.EsSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yebanxian on 2020/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SearchTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EsSearchService esSearchService;

    @Test
    public void searchSimpleWord() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.singleTitle("资生堂", pageable);
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void searchSimpleMatch() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.singleMatch("优衣库羽绒服", pageable);
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void singlePhraseMatch() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.singlePhraseMatch("优衣库羽绒服 ", pageable);
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void singleTerm() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.singleTerm("优衣库羽绒服", pageable);
        list.stream().forEach(x -> System.out.println(x));
        System.out.println("----------------------------------------");
        List<ProductDocument> list2 = esSearchService.singleTerm("无印良品 MUJI 基础润肤化妆水", pageable);
        list2.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void rangeQuery() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.rangeQuery(1580563186394L, 1580563186394L, pageable);
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void searchSimpleMatchJson() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.singleMatchJson("羽绒服", pageable);
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void rangeQueryJson() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.rangeQueryJson(1580563186394L, 1580568184900L, pageable);
        list.stream().forEach(x -> System.out.println(x));
    }

    @Test
    public void multiQueryJson() {
        Pageable pageable = PageRequest.of(0, 10);
        List<ProductDocument> list = esSearchService.multiQueryJson("羽绒服", 1580563186394L, 1580568184900L, pageable);
        list.stream().forEach(x -> System.out.println(x));
    }
}
