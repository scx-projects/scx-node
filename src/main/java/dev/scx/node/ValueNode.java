package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;

/// ValueNode
///
/// @author scx567888
/// @version 0.0.1
public sealed interface ValueNode extends Node permits NumberNode, StringNode, BooleanNode {

    /// 转换为 int (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    int asInt() throws NumberFormatException;

    /// 转换为 int (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    /// @throws ArithmeticException   精度丢失
    int asIntExact() throws NumberFormatException, ArithmeticException;

    /// 转换为 long (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    long asLong() throws NumberFormatException;

    /// 转换为 long (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    /// @throws ArithmeticException   精度丢失
    long asLongExact() throws NumberFormatException, ArithmeticException;

    /// 转换为 float (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    float asFloat() throws NumberFormatException;

    /// 转换为 float (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    /// @throws ArithmeticException   精度丢失
    float asFloatExact() throws NumberFormatException, ArithmeticException;

    /// 转换为 double (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    double asDouble() throws NumberFormatException;

    /// 转换为 double (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    /// @throws ArithmeticException   精度丢失
    double asDoubleExact() throws NumberFormatException, ArithmeticException;

    /// 转换为 BigInteger (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    BigInteger asBigInteger() throws NumberFormatException;

    /// 转换为 BigInteger (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    /// @throws ArithmeticException   精度丢失
    BigInteger asBigIntegerExact() throws NumberFormatException, ArithmeticException;

    /// 转换为 BigDecimal
    ///
    /// @throws NumberFormatException 数字格式不正确 (一般出现在 StringNode 中)
    BigDecimal asBigDecimal() throws NumberFormatException;

    /// 转换为 String
    String asString();

    /// 转换为 boolean
    ///
    /// - 对于 数值类型 : value != 0
    /// - 对于 字符串类型 : "true".equalsIgnoreCase(s)
    ///
    boolean asBoolean();

    @Override
    ValueNode deepCopy();

}
