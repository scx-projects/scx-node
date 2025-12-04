package dev.scx.node.view;

import java.math.BigDecimal;

/// BigDecimalView
///
/// @author scx567888
/// @version 0.0.1
public interface BigDecimalView {

    /// 转换为 BigDecimal
    ///
    /// @throws NumberFormatException 数字格式不正确
    BigDecimal asBigDecimal() throws NumberFormatException;

}
