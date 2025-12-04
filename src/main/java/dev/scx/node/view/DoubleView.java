package dev.scx.node.view;

public interface DoubleView {

    /// 转换为 double (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    double asDouble() throws NumberFormatException;

    /// 转换为 double (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    /// @throws ArithmeticException   精度丢失
    double asDoubleExact() throws NumberFormatException, ArithmeticException;

}
