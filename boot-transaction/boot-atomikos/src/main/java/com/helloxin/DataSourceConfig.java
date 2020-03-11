package com.helloxin;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Configuration
public class DataSourceConfig {

    public DataSourceConfig() {
    }

    @Primary
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource ficusDbDataSource() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword("souche2015");
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("xads1");
        return xaDataSource;
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource yizhuDbDataSource() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl("jdbc:mysql://10.20.12.66:3306/test");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword("yitu1234");
        mysqlXaDataSource.setUser("root");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("xads2");
        return xaDataSource;
    }

}

