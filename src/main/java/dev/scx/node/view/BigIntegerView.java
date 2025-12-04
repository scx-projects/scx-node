package dev.scx.node.view;

import java.math.BigInteger;

public interface BigIntegerView {

    /// 转换为 BigInteger
    ///
    /// @throws NumberFormatException 数字格式不正确
    BigInteger asBigInteger() throws NumberFormatException;

}
