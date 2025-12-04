package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// FloatNode
///
/// ### 关于 equals 重写问题:
/// 浮点比较涉及 ±0.0 和 NaN 的特殊语义, 为了保证 equals 行为一致, 通常需要使用 [Float#compare(float, float)].
/// 但按照 [Record#equals(Object)] 的方法约定, 其底层恰好采用了 这种判断逻辑, 因此我们无需手动重写 equals.
///
/// @author scx567888
/// @version 0.0.1
public record FloatNode(float value) implements NumberNode {

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
        return value;
    }

    @Override
    public float asFloatExact() {
        return value;
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
    public FloatNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        // 采用 JSON 格式
        return asString();
    }

}
