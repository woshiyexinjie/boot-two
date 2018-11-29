package com.helloxin.mongodb.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;


public class MongoOperatorServiceImpl implements MongoOperatorService {

	final static Logger LOGGER = LoggerFactory.getLogger(MongoOperatorServiceImpl.class);
	

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    
    private String connectionUrl = "mongodb://localhost:27017";
    private String databaseName = "helloxin";

	
	
	@Override
	public void  mongodbTest() {
		if(mongoDatabase == null) {
            MongoClientURI connectionString = new MongoClientURI(connectionUrl);
            mongoClient = new MongoClient(connectionString);
            mongoDatabase = mongoClient.getDatabase(databaseName);
        }
	}
	
}
