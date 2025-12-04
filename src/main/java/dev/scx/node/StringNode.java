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
        return Integer.parseInt(value);
    }

    @Override
    public int asIntExact() throws NumberFormatException {
        return Integer.parseInt(value);
    }

    @Override
    public long asLong() throws NumberFormatException {
        return Long.parseLong(value);
    }

    @Override
    public long asLongExact() throws NumberFormatException {
        return Long.parseLong(value);
    }

    @Override
    public float asFloat() throws NumberFormatException {
        return Float.parseFloat(value);
    }

    @Override
    public float asFloatExact() throws NumberFormatException {
        return Float.parseFloat(value);
    }

    @Override
    public double asDouble() throws NumberFormatException {
        return Double.parseDouble(value);
    }

    @Override
    public double asDoubleExact() throws NumberFormatException {
        return Double.parseDouble(value);
    }

    @Override
    public BigInteger asBigInteger() throws NumberFormatException {
        return new BigInteger(value);
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
