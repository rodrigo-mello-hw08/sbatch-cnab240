package com.bv.cwi.poc.config.job;

import com.bv.cwi.poc.domain.LinhaCnab;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ReaderConfiguration {

    @Value(value = "classpath:cnab/cnabsocomdetalheaeb.REM")
    private Resource arquivo;

    @Bean("cnabReader2")
    public MultilineItemReader itemReaderML(
        @Qualifier("mapperE") PatternMatchingCompositeLineMapper patternLineMapper
    ) {
        FlatFileItemReader flatFileReader = new FlatFileItemReaderBuilder<LinhaCnab>()
                .name("itemReader")
                .resource(arquivo)
                .lineMapper(patternLineMapper)
                .build();
        return new MultilineItemReader(flatFileReader);
    }

}
