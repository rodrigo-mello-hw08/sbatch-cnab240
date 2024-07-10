package com.bv.cwi.poc.config.job;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class JobConfiguration {

    @Bean
    public Job job(
            JobRepository jobRepository,
            @Qualifier("stepInterpretarCnab") Step interpretarCnab
    ) {
        return new JobBuilder("cnab240job", jobRepository)
            .incrementer(new RunIdIncrementer())
            .start(interpretarCnab).build();
    }

}
