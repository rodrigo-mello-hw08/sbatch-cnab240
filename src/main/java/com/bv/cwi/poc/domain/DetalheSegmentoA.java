package com.bv.cwi.poc.domain;

import com.bv.cwi.poc.domain.enums.CampoDetalheAEnum;
import lombok.Data;

@Data
public class DetalheSegmentoA extends LinhaCnab {
    private String banco;
    private Integer lote;
    private String tipoRegistro;
    private Integer numeroRegistro;
    private String segmento;
    private Integer tipoMovimento;
    private Integer tipoCodigo;
    private Integer codigoCamara;
    private String codigoBanco;

    @Override
    public String obterIdentificador() {
        return CampoDetalheAEnum.IDENTIFICADOR;
    }

}
