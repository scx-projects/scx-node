package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// StringNode
///
/// @author scx567888
/// @version 0.0.1
public record StringNode(String value) implements ValueNode {

    public StringNode {
        if (value == null) {
            throw new NullPointerException("StringNode value cannot be null");
        }
    }

    @Override
    public int asInt() throws NumberFormatException {
        return new BigDecimal(value).intValue();
    }

    @Override
    public int asIntExact() throws NumberFormatException, ArithmeticException {
        return new BigDecimal(value).intValueExact();
    }

    @Override
    public long asLong() throws NumberFormatException {
        return new BigDecimal(value).longValue();
    }

    @Override
    public long asLongExact() throws NumberFormatException, ArithmeticException {
        return new BigDecimal(value).longValueExact();
    }

    @Override
    public float asFloat() throws NumberFormatException {
        return new BigDecimal(value).floatValue();
    }

    @Override
    public float asFloatExact() throws NumberFormatException, ArithmeticException {
        var x = new BigDecimal(value);
        var f = x.floatValue();
        if (BigDecimal.valueOf(f).compareTo(x) != 0) {
            throw new ArithmeticException("Precision loss: " + value);
        }
        return f;
    }

    @Override
    public double asDouble() throws NumberFormatException {
        return new BigDecimal(value).doubleValue();
    }

    @Override
    public double asDoubleExact() throws NumberFormatException, ArithmeticException {
        var x = new BigDecimal(value);
        var d = x.doubleValue();
        if (BigDecimal.valueOf(d).compareTo(x) != 0) {
            throw new ArithmeticException("Precision loss: " + value);
        }
        return d;
    }

    @Override
    public BigInteger asBigInteger() throws NumberFormatException {
        return new BigDecimal(value).toBigInteger();
    }

    @Override
    public BigInteger asBigIntegerExact() throws NumberFormatException, ArithmeticException {
        return new BigDecimal(value).toBigIntegerExact();
    }

    @Override
    public BigDecimal asBigDecimal() throws NumberFormatException {
        return new BigDecimal(value);
    }

    @Override
    public String asString() {
        return value;
    }

    @Override
    public boolean asBoolean() {
        return Boolean.parseBoolean(value);
    }

    @Override
    public StringNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        // 采用 JSON 格式
        // 这里不考虑复杂的转义, 只做 引号包裹.
        return "\"" + value + "\"";
    }

}
