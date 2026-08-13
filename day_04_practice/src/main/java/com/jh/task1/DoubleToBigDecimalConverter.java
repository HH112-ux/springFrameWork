package com.jh.task1;

import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

/**
 * 自定义类型转换器：将Double类型转换为BigDecimal类型
 */
public class DoubleToBigDecimalConverter implements Converter<Double, BigDecimal> {
    @Override
    public BigDecimal convert(Double source) {
        if (source == null) {
            return null;
        }
        return BigDecimal.valueOf(source);
    }
}
