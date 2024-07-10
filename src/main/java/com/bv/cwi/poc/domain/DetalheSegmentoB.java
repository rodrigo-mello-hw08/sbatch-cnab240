package com.bv.cwi.poc.domain;

import com.bv.cwi.poc.domain.enums.CampoDetalheBEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalheSegmentoB extends LinhaCnab {
    private String banco;
    private Integer lote;
    private String tipoRegistro;
    private Integer numeroRegistro;
    private String segmento;
    private String fillerCnab;
    private Integer tipoInscricaoFavorecido;
    private String numInscricaoFavorecido;
    private BigDecimal valorDocumento;

    @Override
    public String obterIdentificador() {
        return CampoDetalheBEnum.IDENTIFICADOR;
    }

}
