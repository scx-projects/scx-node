package dev.scx.node.view;

/// IntView
///
/// @author scx567888
/// @version 0.0.1
public interface IntView {

    /// 转换为 int (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    int asInt() throws NumberFormatException;

    /// 转换为 int (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    /// @throws ArithmeticException   精度丢失
    int asIntExact() throws NumberFormatException, ArithmeticException;

}
