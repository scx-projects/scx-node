package dev.scx.node.view;

import java.math.BigInteger;

/// BigIntegerView
///
/// @author scx567888
/// @version 0.0.1
public interface BigIntegerView {

    /// 转换为 BigInteger (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    BigInteger asBigInteger() throws NumberFormatException;

    /// 转换为 BigInteger (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    /// @throws ArithmeticException   精度丢失
    BigInteger asBigIntegerExact() throws NumberFormatException, ArithmeticException;

}
