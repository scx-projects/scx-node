package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// BigIntegerNode
///
/// @author scx567888
/// @version 0.0.1
public record BigIntegerNode(BigInteger value) implements NumberNode {

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
    public long asLong() {
        return value.longValue();
    }

    @Override
    public float asFloat() {
        return value.floatValue();
    }

    @Override
    public double asDouble() {
        return value.doubleValue();
    }

    @Override
    public BigInteger asBigInteger() {
        return value;
    }

    @Override
    public BigDecimal asBigDecimal() {
        return new BigDecimal(value);
    }

    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public boolean asBoolean() {
        return !value.equals(BigInteger.ZERO);
    }

    /// 值类型不可变 返回 this 即可
    @Override
    public BigIntegerNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asText();
    }

}
