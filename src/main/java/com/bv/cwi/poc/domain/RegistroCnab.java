package com.bv.cwi.poc.domain;

import lombok.Data;

import static java.util.Objects.nonNull;

@Data
public class RegistroCnab {
    private DetalheSegmentoA detalheSegmentoA;
    private DetalheSegmentoB detalheSegmentoB;

    public boolean registroCompleto() {
        return nonNull(detalheSegmentoA) && nonNull(detalheSegmentoB);
    }

}
