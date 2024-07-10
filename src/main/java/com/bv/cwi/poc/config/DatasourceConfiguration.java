package com.bv.cwi.poc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {

    @Primary
    @Bean("dataSource")
    @ConfigurationProperties(prefix = "app.mysql.db")
    public DataSource mysqlDatasource() {
        return DataSourceBuilder.create().build();
    }

}
