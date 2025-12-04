package dev.scx.node;

import dev.scx.node.view.BooleanView;
import dev.scx.node.view.NumberView;
import dev.scx.node.view.StringView;

import java.math.BigDecimal;
import java.math.BigInteger;

/// BigIntegerNode
///
/// @author scx567888
/// @version 0.0.1
public record BigIntegerNode(BigInteger value) implements NumberNode, NumberView, StringView, BooleanView {

    public BigIntegerNode {
        if (value == null) {
            throw new NullPointerException("BigIntegerNode value cannot be null");
        }
    }

    @Override
    public int asInt() {
        return value.intValue();
    }

    @Override
    public int asIntExact() throws NumberFormatException, ArithmeticException {
        return value.intValueExact();
    }

    @Override
    public long asLong() {
        return value.longValue();
    }

    @Override
    public long asLongExact() throws NumberFormatException, ArithmeticException {
        return value.longValueExact();
    }

    @Override
    public float asFloat() {
        return value.floatValue();
    }

    @Override
    public float asFloatExact() throws NumberFormatException, ArithmeticException {
        // todo 判断方式存疑
        // float 的最大可精确整数是 2^24
        if (value.bitLength() > 24) {
            // 超过精度范围
            throw new ArithmeticException("Precision loss converting BigInteger to float");
        }
        return value.floatValue();
    }

    @Override
    public double asDouble() {
        return value.doubleValue();
    }

    @Override
    public double asDoubleExact() throws NumberFormatException, ArithmeticException {
        // todo 判断方式存疑
        // double 的最大可精确整数是 2^53
        if (value.bitLength() > 53) {
            // 超过精度范围
            throw new ArithmeticException("Precision loss converting BigInteger to double");
        }
        return value.doubleValue();
    }

    @Override
    public BigInteger asBigInteger() {
        return value;
    }

    @Override
    public BigInteger asBigIntegerExact() {
        return value;
    }

    @Override
    public BigDecimal asBigDecimal() {
        return new BigDecimal(value);
    }

    @Override
    public String asString() {
        return value.toString();
    }

    @Override
    public boolean asBoolean() {
        return !value.equals(BigInteger.ZERO);
    }

    @Override
    public BigIntegerNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asString();
    }

}
