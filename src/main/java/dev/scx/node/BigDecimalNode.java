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
        return value.toBigInteger();
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
        return !value.equals(BigDecimal.ZERO);
    }

    /// 值类型不可变 返回 this 即可
    @Override
    public BigDecimalNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asString();
    }

}
