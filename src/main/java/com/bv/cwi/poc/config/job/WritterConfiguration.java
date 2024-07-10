package com.bv.cwi.poc.config.job;

import com.bv.cwi.poc.domain.RegistroCnab;
import com.bv.cwi.poc.utils.FileUtils;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class WritterConfiguration {

    @Value(value = "classpath:sql/writter/inserirRegistroCnab2.sql")
    private Resource inserirRegistroCnab2;

    @Bean(name = "cnabWritter2")
    public JdbcBatchItemWriter<RegistroCnab> cnabWritter2(
            @Qualifier("dataSource") DataSource dataSource
    ) throws IOException {
        return new JdbcBatchItemWriterBuilder<RegistroCnab>()
                .dataSource(dataSource)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(FileUtils.getSqlFromResource(inserirRegistroCnab2))
                .build();
    }

}
