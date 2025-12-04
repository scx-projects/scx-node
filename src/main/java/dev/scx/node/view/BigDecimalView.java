package dev.scx.node.view;

import java.math.BigDecimal;

public interface BigDecimalView {

    /// 转换为 BigDecimal
    ///
    /// @throws NumberFormatException 数字格式不正确
    BigDecimal asBigDecimal() throws NumberFormatException;

}
