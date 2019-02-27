package com.helloxin.es.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloxin.es.document.ProductDocument;
import com.helloxin.es.service.EsSearchService;

@RestController
public class EsSearchController {
	
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private EsSearchService esSearchService;

    @RequestMapping("save")
    public String add(@RequestBody ProductDocument productDocument) {
        esSearchService.save(productDocument);
        return "success";
    }

}
