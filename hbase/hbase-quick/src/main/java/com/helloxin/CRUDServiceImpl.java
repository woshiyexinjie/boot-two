package com.helloxin;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CRUDServiceImpl implements ICRUDService {
    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Override
    public User findByRow(String tableName, String row) {
        return hbaseTemplate.get(tableName, row, new UserRowMapper());
    }

    @Override
    public void createTable(String tableName) throws IOException {
        Configuration conf = hbaseTemplate.getConfiguration();
        HBaseAdmin client = new HBaseAdmin(conf);
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
        HColumnDescriptor h1 = new HColumnDescriptor("baseInfo");
        HColumnDescriptor h2 = new HColumnDescriptor("otherInfo");
        htd.addFamily(h1);
        htd.addFamily(h2);
        client.createTable(htd);
        client.close();
    }

    @Override
    public List<User> findBySERow(String tableName, String startRow, String endRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(endRow));
        return hbaseTemplate.find(tableName, scan, new UserRowMapper());
    }

    @Override
    public List<Mutation> saveOrUpdate(String tablename, List<Mutation> datas) {
        hbaseTemplate.saveOrUpdates(tablename, datas);
        return datas;
    }
}