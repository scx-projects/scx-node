package dev.scx.node.view;

public interface LongView {

    /// 转换为 long (允许丢失精度)
    ///
    /// @return int
    /// @throws NumberFormatException 数字格式不正确
    int asLong() throws NumberFormatException;

    /// 转换为 long (不允许丢失精度)
    ///
    /// @return int
    /// @throws NumberFormatException 数字格式不正确
    /// @throws ArithmeticException 精度丢失
    int asLongExact() throws NumberFormatException, ArithmeticException;

}
