package com.bv.cwi.poc.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class BigDecimalUtils {

    public static BigDecimal formatarValores(String entrada) {
        // Remover os zeros à esquerda
        String valorStr = entrada.replaceFirst("^0+", "");

        String parteInteira = valorStr.substring(0, valorStr.length() - 2);
        String parteDecimal = valorStr.substring(valorStr.length() - 2);

        return new BigDecimal(parteInteira + "." + parteDecimal);
    }

}
