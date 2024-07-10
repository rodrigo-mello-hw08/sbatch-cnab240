package com.bv.cwi.poc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.batch.item.file.transform.Range;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CampoDetalheAEnum {
    BANCO("banco", new Range(1, 3), 0, TipoDadoCnabEnum.STRING),
    LOTE("lote", new Range(4, 7), 1, TipoDadoCnabEnum.INTEIRO),
    TIPO_REGISTRO("tipoRegistro", new Range(8, 8), 2, TipoDadoCnabEnum.STRING),
    NUMERO_REGISTRO("numeroRegistro", new Range(9, 13), 3, TipoDadoCnabEnum.INTEIRO),
    SEGMENTO("segmento", new Range(14, 14), 4, TipoDadoCnabEnum.STRING),
    TIPO_MOVIMENTO("tipoMovimento", new Range(15, 15), 5, TipoDadoCnabEnum.INTEIRO),
    TIPO_CODIGO("tipoCodigo", new Range(16, 17), 6, TipoDadoCnabEnum.INTEIRO),
    CODIGO_CAMARA("codigoCamara", new Range(18, 20), 7, TipoDadoCnabEnum.INTEIRO),
    CODIGO_BANCO("codigoBanco", new Range(21, 23), 8, TipoDadoCnabEnum.STRING),
    ;
    private final String nomeCampo;
    private final Range range;
    private final Integer posicao;
    private final TipoDadoCnabEnum tipoDado;
    public static final String IDENTIFICADOR = "DA";

    public static final String MATCHER = "*3?????A*";

    public static String[] getNomesCampos() {
        return Arrays.stream(values())
            .map(CampoDetalheAEnum::getNomeCampo)
            .toList()
            .toArray(new String[0]);
    }

    public static Range[] getRangesCampos() {
        return Arrays.stream(values())
            .map(CampoDetalheAEnum::getRange)
            .toList()
            .toArray(new Range[0]);
    }

}
