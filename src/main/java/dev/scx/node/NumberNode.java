package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// NumberNode
///
/// 移除 asXXX 上的 throws NumberFormatException (因为不可能发生)
///
/// @author scx567888
/// @version 0.0.1
public sealed interface NumberNode extends ValueNode permits IntNode, LongNode, FloatNode, DoubleNode, BigIntegerNode, BigDecimalNode {

    @Override
    int asInt();

    @Override
    int asIntExact() throws ArithmeticException;

    @Override
    long asLong();

    @Override
    long asLongExact() throws ArithmeticException;

    @Override
    float asFloat();

    @Override
    float asFloatExact() throws ArithmeticException;

    @Override
    double asDouble();

    @Override
    double asDoubleExact() throws ArithmeticException;

    @Override
    BigInteger asBigInteger();

    @Override
    BigInteger asBigIntegerExact() throws ArithmeticException;

    @Override
    BigDecimal asBigDecimal();

    @Override
    NumberNode deepCopy();

}
