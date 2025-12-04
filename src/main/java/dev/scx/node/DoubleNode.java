package dev.scx.node;

import dev.scx.node.view.BooleanView;
import dev.scx.node.view.NumberView;
import dev.scx.node.view.StringView;

import java.math.BigDecimal;
import java.math.BigInteger;

/// DoubleNode
///
/// 关于 equals 重写问题: 参考 [FloatNode].
///
/// @author scx567888
/// @version 0.0.1
public record DoubleNode(double value) implements NumberNode, NumberView, StringView, BooleanView {

    @Override
    public int asInt() {
        return (int) value;
    }

    @Override
    public int asIntExact() throws ArithmeticException {
        if ((double) (int) value != value) {
            throw new ArithmeticException("Precision loss: " + value);
        }
        return (int) value;
    }

    @Override
    public long asLong() {
        return (long) value;
    }

    @Override
    public long asLongExact() throws ArithmeticException {
        if ((double) (long) value != value) {
            throw new ArithmeticException("Precision loss: " + value);
        }
        return (long) value;
    }

    @Override
    public float asFloat() {
        return (float) value;
    }

    @Override
    public float asFloatExact() throws ArithmeticException {
        if ((double) (float) value != value) {
            throw new ArithmeticException("Precision loss: " + value);
        }
        return (float) value;
    }

    @Override
    public double asDouble() {
        return value;
    }

    @Override
    public double asDoubleExact() {
        return value;
    }

    @Override
    public BigInteger asBigInteger() {
        return BigDecimal.valueOf(value).toBigInteger();
    }

    @Override
    public BigInteger asBigIntegerExact() throws ArithmeticException {
        return BigDecimal.valueOf(value).toBigIntegerExact();
    }

    @Override
    public BigDecimal asBigDecimal() {
        return BigDecimal.valueOf(value);
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public boolean asBoolean() {
        return value != 0;
    }

    @Override
    public DoubleNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asString();
    }

}
