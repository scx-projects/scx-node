package dev.scx.node.view;

import java.math.BigInteger;

/// BigIntegerView
///
/// @author scx567888
/// @version 0.0.1
public interface BigIntegerView {

    /// 转换为 BigInteger
    ///
    /// @throws NumberFormatException 数字格式不正确
    BigInteger asBigInteger() throws NumberFormatException;

}
