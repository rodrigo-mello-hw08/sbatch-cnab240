package com.bv.cwi.poc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.batch.item.file.transform.Range;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CampoDetalheBEnum {
    BANCO("banco", new Range(1, 3), 0, TipoDadoCnabEnum.STRING),
    LOTE("lote", new Range(4, 7), 1, TipoDadoCnabEnum.INTEIRO),
    TIPO_REGISTRO("tipoRegistro", new Range(8, 8), 2, TipoDadoCnabEnum.STRING),
    NUMERO_REGISTRO("numeroRegistro", new Range(9, 13), 3, TipoDadoCnabEnum.INTEIRO),
    SEGMENTO("segmento", new Range(14, 14), 4, TipoDadoCnabEnum.STRING),
    FILLER_CNAB("fillerCnab", new Range(15, 17), 5, TipoDadoCnabEnum.STRING),
    TIPO_INSCRICAO_FAVORECIDO("tipoInscricaoFavorecido", new Range(18, 18), 6, TipoDadoCnabEnum.INTEIRO),
    NUM_INSCRICAO_FAVORECIDO("numInscricaoFavorecido", new Range(19, 32), 7, TipoDadoCnabEnum.STRING),
    VALOR_DOCUMENTO("valorDocumento", new Range(136, 150), 8, TipoDadoCnabEnum.VALOR),
    ;
    private final String nomeCampo;
    private final Range range;
    private final Integer posicao;
    private final TipoDadoCnabEnum tipoDado;
    public static final String IDENTIFICADOR = "DB";
    public static final String MATCHER = "*3?????B*";

    public static String[] getNomesCampos() {
        return Arrays.stream(values())
            .map(CampoDetalheBEnum::getNomeCampo)
            .toList()
            .toArray(new String[0]);
    }

    public static Range[] getRangesCampos() {
        return Arrays.stream(values())
            .map(CampoDetalheBEnum::getRange)
            .toList()
            .toArray(new Range[0]);
    }

}
