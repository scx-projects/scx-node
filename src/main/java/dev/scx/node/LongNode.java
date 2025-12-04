package dev.scx.node;

import dev.scx.node.view.BooleanView;
import dev.scx.node.view.NumberView;
import dev.scx.node.view.StringView;

import java.math.BigDecimal;
import java.math.BigInteger;

/// LongNode
///
/// @author scx567888
/// @version 0.0.1
public record LongNode(long value) implements NumberNode, NumberView, StringView, BooleanView {

    @Override
    public int asInt() {
        return (int) value;
    }

    @Override
    public int asIntExact() throws ArithmeticException {
        if ((int) value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) value;
    }

    @Override
    public long asLong() {
        return value;
    }

    @Override
    public long asLongExact() {
        return value;
    }

    @Override
    public float asFloat() {
        return value;
    }

    @Override
    public float asFloatExact() throws ArithmeticException {
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
    public double asDoubleExact() throws ArithmeticException {
        if ((double) value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (double) value;
    }

    @Override
    public BigInteger asBigInteger() {
        return BigInteger.valueOf(value);
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
    public LongNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asString();
    }

}
