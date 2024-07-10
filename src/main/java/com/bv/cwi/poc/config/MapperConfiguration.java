package com.bv.cwi.poc.config;


import com.bv.cwi.poc.domain.DetalheSegmentoA;
import com.bv.cwi.poc.domain.DetalheSegmentoB;
import com.bv.cwi.poc.domain.LinhaCnab;
import com.bv.cwi.poc.domain.enums.CampoDetalheAEnum;
import com.bv.cwi.poc.domain.enums.CampoDetalheBEnum;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MapperConfiguration {

    @Bean("mapperE")
    public PatternMatchingCompositeLineMapper patternMatchingCompositeLineMapper() {
        Map<String, LineTokenizer> tokenizerMap = new HashMap<>(2);
        tokenizerMap.put(CampoDetalheAEnum.MATCHER, tokenizers(CampoDetalheAEnum.getNomesCampos(), CampoDetalheAEnum.getRangesCampos()));
        tokenizerMap.put(CampoDetalheBEnum.MATCHER, tokenizers(CampoDetalheBEnum.getNomesCampos(), CampoDetalheBEnum.getRangesCampos()));
        tokenizerMap.put("*", defaultTokenizer());

        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
        lineMapper.setTokenizers(tokenizerMap);

        Map<String, FieldSetMapper> mappers = new HashMap<>(2);
        mappers.put(CampoDetalheAEnum.MATCHER, gerarFieldSetMapper(DetalheSegmentoA.class));
        mappers.put(CampoDetalheBEnum.MATCHER, gerarFieldSetMapper(DetalheSegmentoB.class));
        mappers.put("*", gerarFieldSetMapper(LinhaCnab.class));

        lineMapper.setFieldSetMappers(mappers);
        return lineMapper;
    }

    private FixedLengthTokenizer tokenizers(String[] nomeCampos, Range[] ranges) {
        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setStrict(false);
        return personalizarTokenizer(tokenizer, nomeCampos, ranges);
    }

    private FixedLengthTokenizer defaultTokenizer() {
        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setStrict(false);

        String[] campo = {"mensagem"};
        Range[] range = {new Range(1, 240)};
        return personalizarTokenizer(tokenizer, campo, range);
    }

    private FixedLengthTokenizer personalizarTokenizer(FixedLengthTokenizer tokenizer, String[] nomeCampos, Range[] ranges) {
        tokenizer.setNames(nomeCampos);
        tokenizer.setColumns(ranges);
        return tokenizer;
    }

    public static FieldSetMapper gerarFieldSetMapper(Class classeDestino) {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(classeDestino);
        return fieldSetMapper;
    }

}
