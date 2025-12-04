package dev.scx.node;

import dev.scx.node.view.BooleanView;
import dev.scx.node.view.NumberView;
import dev.scx.node.view.StringView;

import java.math.BigDecimal;
import java.math.BigInteger;

/// StringNode
///
/// @author scx567888
/// @version 0.0.1
public record StringNode(String value) implements ValueNode, NumberView, StringView, BooleanView {

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
        return Float.parseFloat(value);
    }

    @Override
    public float asFloatExact() throws NumberFormatException {
        // todo
        return Float.parseFloat(value);
    }

    @Override
    public double asDouble() throws NumberFormatException {
        return Double.parseDouble(value);
    }

    @Override
    public double asDoubleExact() throws NumberFormatException {
        // todo
        return Double.parseDouble(value);
    }

    @Override
    public BigInteger asBigInteger() throws NumberFormatException {
        return new BigInteger(value);
    }

    @Override
    public BigInteger asBigIntegerExact() throws NumberFormatException, ArithmeticException {
        return null;
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
        return asString();
    }

}
