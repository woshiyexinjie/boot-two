package com.helloxin;

import org.apache.hadoop.hbase.client.Mutation;

import java.io.IOException;
import java.util.List;

public interface ICRUDService {
    User findByRow(String tableName,String row);

    void createTable(String tableName) throws IOException;

    List<User> findBySERow(String tableName, String startRow, String endRow);
    List<Mutation>saveOrUpdate(String tablename, List<Mutation> datas);
}
