package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// BooleanNode
///
/// @author scx567888
/// @version 0.0.1
public final class BooleanNode implements ValueNode {

    public final static BooleanNode TRUE = new BooleanNode(true);
    public final static BooleanNode FALSE = new BooleanNode(false);

    private final boolean value;

    /// 私有化构造函数
    private BooleanNode(boolean value) {
        this.value = value;
    }

    public static BooleanNode of(boolean v) {
        return v ? TRUE : FALSE;
    }

    public boolean value() {
        return value;
    }

    @Override
    public int asInt() {
        return value ? 1 : 0;
    }

    @Override
    public int asIntExact() {
        return value ? 1 : 0;
    }

    @Override
    public long asLong() {
        return value ? 1L : 0L;
    }

    @Override
    public long asLongExact() {
        return value ? 1L : 0L;
    }

    @Override
    public float asFloat() {
        return value ? 1.0F : 0.0F;
    }

    @Override
    public float asFloatExact() {
        return value ? 1.0F : 0.0F;
    }

    @Override
    public double asDouble() {
        return value ? 1.0D : 0.0D;
    }

    @Override
    public double asDoubleExact() {
        return value ? 1.0D : 0.0D;
    }

    @Override
    public BigInteger asBigInteger() {
        return value ? BigInteger.ONE : BigInteger.ZERO;
    }

    @Override
    public BigInteger asBigIntegerExact() {
        return value ? BigInteger.ONE : BigInteger.ZERO;
    }

    @Override
    public BigDecimal asBigDecimal() {
        return value ? BigDecimal.ONE : BigDecimal.ZERO;
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public boolean asBoolean() {
        return value;
    }

    @Override
    public BooleanNode deepCopy() {
        return this;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(value);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof BooleanNode booleanNode) {
            return value == booleanNode.value;
        }
        return false;
    }

    @Override
    public String toString() {
        // 采用 JSON 格式
        return asString();
    }

}
