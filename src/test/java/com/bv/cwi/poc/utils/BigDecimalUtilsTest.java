package com.bv.cwi.poc.utils;

import com.bv.cwi.poc.utils.BigDecimalUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalUtilsTest {

    @Test
    void formatarValores() {
        BigDecimal resultado = BigDecimalUtils.formatarValores("000000000120000");
        assertEquals(new BigDecimal("1200.00"), resultado);
    }
}