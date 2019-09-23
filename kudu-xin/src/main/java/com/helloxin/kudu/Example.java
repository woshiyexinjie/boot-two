package com.helloxin.kudu;

import com.google.common.collect.ImmutableList;

import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.CreateTableOptions;
import org.apache.kudu.client.Insert;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.client.KuduException;
import org.apache.kudu.client.KuduScanner;
import org.apache.kudu.client.KuduSession;
import org.apache.kudu.client.KuduTable;
import org.apache.kudu.client.PartialRow;
import org.apache.kudu.client.RowResult;
import org.apache.kudu.client.RowResultIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * This example creates a 'movies' table for movie information.
 */
public class Example {
  private static final Logger LOG = LoggerFactory.getLogger(Example.class);

  public static void main(String[] args) throws KuduException {


    String masterAddress = "10.20.12.66:7051";
    KuduClient client = new KuduClient.KuduClientBuilder(masterAddress).build();
    try {
    	
    	Example movieTable = new Example();
    		
    	if (!client.tableExists("movie")) {
    		movieTable.create(client);
    	}
    	
    	movieTable.populateSingleRow(client);
    	
    	movieTable.queryData(client);
    	
    } finally {
    	client.shutdown();
    }
   
  }
  
  private void create(KuduClient client) throws KuduException {

	  	LOG.info("in create");
	    ColumnSchema movieId = new ColumnSchema.ColumnSchemaBuilder("movie_id", Type.INT32).key(true).build();
	    ColumnSchema movieName = new ColumnSchema.ColumnSchemaBuilder("movie_name", Type.STRING).build();
	    ColumnSchema movieYear = new ColumnSchema.ColumnSchemaBuilder("movie_year", Type.STRING).build();
	    ColumnSchema movieGenre = new ColumnSchema.ColumnSchemaBuilder("movie_genre", Type.STRING).build();
	    List<ColumnSchema> columns = ImmutableList.of(movieId, movieName, movieYear, movieGenre);
	    Schema schema = new Schema(columns);

	    CreateTableOptions createOptions =
	        new CreateTableOptions().addHashPartitions(ImmutableList.of("movie_id"), 4);

	    String tableName = "movie";
	    client.createTable(tableName, schema, createOptions);

	    LOG.info("Table '{}' created", tableName);
	    Schema movieSchema = client.openTable("movie").getSchema();
	    LOG.info("Number of columns in table " + movieSchema.getColumnCount());
	   
	    for (ColumnSchema colSchema : movieSchema.getColumns()) {
	    	LOG.info("Columns in table " + colSchema.getName() + "is primary key " + colSchema.isKey());
	    }
  }
  
  private void populateSingleRow(KuduClient client) throws KuduException {
	  
	  KuduSession session = client.newSession();
	  
	  KuduTable table = client.openTable("movie");
	  
	  Insert insert = table.newInsert();
	  PartialRow row = insert.getRow();
	  row.addInt(0, 1);
	  row.addString(1, "Star Wars Force Awakens ");
	  row.addString(2, "2016");
	  row.addString(3,  "Sci-Fi");
	  
	  session.apply(insert);
	  session.flush();
	  session.close();
	  
	  LOG.info("added one record" );
	  
  }
  
  private void queryData(KuduClient client) throws KuduException {
	  

	  KuduTable table = client.openTable("movie");

	  KuduScanner kuduScanner = client.newScannerBuilder(table).build();
	  while (kuduScanner.hasMoreRows()) {
		  RowResultIterator rows = kuduScanner.nextRows();
		  while (rows.hasNext()) {
			  RowResult row = rows.next();
			  LOG.info("row value " + row.rowToString());
		  }
			  
	  }
	  
  }
    
  
}
