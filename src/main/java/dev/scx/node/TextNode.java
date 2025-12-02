package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// TextNode
///
/// @author scx567888
/// @version 0.0.1
public record TextNode(String value) implements ValueNode {

    public TextNode {
        if (value == null) {
            throw new NullPointerException("TextNode value cannot be null");
        }
    }

    @Override
    public int asInt() throws NumberFormatException {
        return Integer.parseInt(value);
    }

    @Override
    public long asLong() throws NumberFormatException {
        return Long.parseLong(value);
    }

    @Override
    public float asFloat() throws NumberFormatException {
        return Float.parseFloat(value);
    }

    @Override
    public double asDouble() throws NumberFormatException {
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
    public String asText() {
        return value;
    }

    @Override
    public boolean asBoolean() {
        return Boolean.parseBoolean(value);
    }

    /// 值类型不可变 返回 this 即可
    @Override
    public TextNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asText();
    }

}
