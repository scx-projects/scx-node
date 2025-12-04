package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// LongNode
///
/// @author scx567888
/// @version 0.0.1
public record LongNode(long value) implements NumberNode {

    @Override
    public int asInt() {
        return (int) value;
    }

    @Override
    public long asLong() {
        return value;
    }

    @Override
    public float asFloat() {
        return value;
    }

    @Override
    public double asDouble() {
        return value;
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

    /// 值类型不可变 返回 this 即可
    @Override
    public LongNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asString();
    }

}
