package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// DoubleNode
///
/// 关于 equals 重写问题: 参考 [FloatNode].
///
/// @author scx567888
/// @version 0.0.1
public record DoubleNode(double value) implements NumberNode {

    @Override
    public int asInt() {
        return (int) value;
    }

    @Override
    public long asLong() {
        return (long) value;
    }

    @Override
    public float asFloat() {
        return (float) value;
    }

    @Override
    public double asDouble() {
        return value;
    }

    @Override
    public BigInteger asBigInteger() {
        return BigDecimal.valueOf(value).toBigInteger();
    }

    @Override
    public BigDecimal asBigDecimal() {
        return BigDecimal.valueOf(value);
    }

    @Override
    public String asText() {
        return String.valueOf(value);
    }

    @Override
    public boolean asBoolean() {
        return value != 0;
    }

    /// 值类型不可变 返回 this 即可
    @Override
    public DoubleNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        return asText();
    }

}
