package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// BigDecimalNode
///
/// @author scx567888
/// @version 0.0.1
public record BigDecimalNode(BigDecimal value) implements NumberNode {

    public BigDecimalNode {
        if (value == null) {
            throw new NullPointerException("BigDecimalNode value cannot be null");
        }
    }

    @Override
    public int asInt() {
        return value.intValue();
    }

    @Override
    public int asIntExact() throws ArithmeticException {
        return value.intValueExact();
    }

    @Override
    public long asLong() {
        return value.longValue();
    }

    @Override
    public long asLongExact() throws ArithmeticException {
        return value.longValueExact();
    }

    @Override
    public float asFloat() {
        return value.floatValue();
    }

    @Override
    public float asFloatExact() throws ArithmeticException {
        var f = value.floatValue();
        if (BigDecimal.valueOf(f).compareTo(value) != 0) {
            throw new ArithmeticException("Precision loss: " + value);
        }
        return f;
    }

    @Override
    public double asDouble() {
        return value.doubleValue();
    }

    @Override
    public double asDoubleExact() throws ArithmeticException {
        var d = value.doubleValue();
        if (BigDecimal.valueOf(d).compareTo(value) != 0) {
            throw new ArithmeticException("Precision loss: " + value);
        }
        return d;
    }

    @Override
    public BigInteger asBigInteger() {
        return value.toBigInteger();
    }

    @Override
    public BigInteger asBigIntegerExact() throws ArithmeticException {
        return value.toBigIntegerExact();
    }

    @Override
    public BigDecimal asBigDecimal() {
        return value;
    }

    @Override
    public String asString() {
        return value.toString();
    }

    @Override
    public boolean asBoolean() {
        return value.compareTo(BigDecimal.ZERO) != 0;
    }

    @Override
    public BigDecimalNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        // 采用 JSON 格式
        return asString();
    }

}
