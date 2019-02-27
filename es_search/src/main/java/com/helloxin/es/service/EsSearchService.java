package com.helloxin.es.service;

import com.helloxin.es.document.ProductDocument;

public interface EsSearchService {
	
	void save(ProductDocument... productDocuments);

}
