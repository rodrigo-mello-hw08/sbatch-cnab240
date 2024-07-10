package com.bv.cwi.poc.config.job;

import com.bv.cwi.poc.domain.RegistroCnab;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepConfiguration {

    @Bean(name = "stepInterpretarCnab")
    public Step stepInterpretarCnab (
            @Autowired JobRepository jobRepository,
            @Qualifier("cnabReader2") MultilineItemReader reader,
            @Qualifier("cnabWritter2") JdbcBatchItemWriter<RegistroCnab> writer,
            PlatformTransactionManager transactionManager
    ) {
        return new StepBuilder("processamentoCnab", jobRepository)
                .<RegistroCnab, RegistroCnab>chunk(100, transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
