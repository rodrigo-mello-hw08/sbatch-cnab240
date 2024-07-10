package com.bv.cwi.poc.domain.enums;

import com.bv.cwi.poc.utils.BigDecimalUtils;
import org.springframework.batch.item.file.transform.FieldSet;

public enum TipoDadoCnabEnum {
    STRING() {
        @Override
        public String parsear(FieldSet fs, Integer indice) {
            return fs.readString(indice);
        }
    },
    INTEIRO() {
        @Override
        public Integer parsear(FieldSet fs, Integer indice) {
            return fs.readInt(indice);
        }
    },
    VALOR() {
        @Override
        public Object parsear(FieldSet fs, Integer indice) {
            return BigDecimalUtils.formatarValores(fs.readString(indice));
        }
    }
    ;

    public abstract Object parsear(FieldSet fs, Integer indice);

}
