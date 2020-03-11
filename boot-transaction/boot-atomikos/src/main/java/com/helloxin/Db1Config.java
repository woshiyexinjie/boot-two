package com.helloxin;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.helloxin.mapper.local"}, sqlSessionFactoryRef = "sqlSessionFactoryDb1")
public class Db1Config {

    @Autowired
    @Qualifier("db1")
    private DataSource dataSourceDb1;

    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactoryDb1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceDb1);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:local/*.xml"));
        return factoryBean.getObject();
    }

    @Primary
    @Bean
    public SqlSessionTemplate sqlSessionTemplateDb1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDb1());
    }
}
