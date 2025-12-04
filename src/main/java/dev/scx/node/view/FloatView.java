package dev.scx.node.view;

public interface FloatView {

    /// 转换为 float (允许丢失精度)
    ///
    /// @return int
    /// @throws NumberFormatException 数字格式不正确
    int asFloat() throws NumberFormatException;

    /// 转换为 float (不允许丢失精度)
    ///
    /// @return int
    /// @throws NumberFormatException 数字格式不正确
    /// @throws ArithmeticException 精度丢失
    int asFloatExact() throws NumberFormatException, ArithmeticException;

}
