package dev.scx.node.view;

/// FloatView
///
/// @author scx567888
/// @version 0.0.1
public interface FloatView {

    /// 转换为 float (允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    float asFloat() throws NumberFormatException;

    /// 转换为 float (不允许丢失精度)
    ///
    /// @throws NumberFormatException 数字格式不正确
    /// @throws ArithmeticException   精度丢失
    float asFloatExact() throws NumberFormatException, ArithmeticException;

}
