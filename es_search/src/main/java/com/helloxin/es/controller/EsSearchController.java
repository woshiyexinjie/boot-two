package com.helloxin.es.controller;

import com.helloxin.es.document.ProductDocument;
import com.helloxin.es.service.EsSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsSearchController {
	
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private EsSearchService esSearchService;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String add(@RequestBody ProductDocument productDocument) {
        esSearchService.save(productDocument);
        return "success";
    }

    @RequestMapping(value = "query",method = RequestMethod.GET)
    public ProductDocument queryById(@RequestParam("query")String query) {
        ProductDocument productDocument = esSearchService.queryOrder(query);
        return productDocument;
    }

    @RequestMapping(value = "deleteById",method = RequestMethod.DELETE)
    public Boolean deleteById(@RequestParam("id")String id) {
        esSearchService.deleteById(id);
        return true;
    }

//    @RequestMapping(value = "query",method = RequestMethod.GET)
//    public List queryByDate(@RequestParam("begin") Date begin,
//                                       @RequestParam("end") Date end) {
//        List<ProductDocument> list = esSearchService.queryOrderbDate(begin,end);
//        return list;
//    }



}
