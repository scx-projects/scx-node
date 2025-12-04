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
    public int asIntExact() throws NumberFormatException, ArithmeticException {
        if ((int) value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) value;
    }

    @Override
    public long asLong() {
        return (long) value;
    }

    @Override
    public long asLongExact() throws NumberFormatException, ArithmeticException {
        if ((long) value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (long) value;
    }

    @Override
    public float asFloat() {
        return (float) value;
    }

    @Override
    public float asFloatExact() throws NumberFormatException, ArithmeticException {
        if ((float) value != value) {
            throw new ArithmeticException("integer overflow");
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
    public BigInteger asBigInteger() throws NumberFormatException {
        return BigDecimal.valueOf(value).toBigInteger();
    }

    @Override
    public BigInteger asBigIntegerExact() throws NumberFormatException, ArithmeticException {
        return BigDecimal.valueOf(value).toBigIntegerExact();
    }

    @Override
    public BigDecimal asBigDecimal() {
        return BigDecimal.valueOf(value);
    }

    @Override
    public String asString() {
        return Double.toString(value);
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
