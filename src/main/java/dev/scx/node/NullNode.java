package dev.scx.node;

/// NullNode
///
/// @author scx567888
/// @version 0.0.1
public final class NullNode implements Node {

    public final static NullNode NULL = new NullNode();

    /// 私有化构造函数
    private NullNode() {

    }

    @Override
    public NullNode deepCopy() {
        return this;
    }

    @Override
    public String toString() {
        // 采用 JSON 格式
        return "null";
    }

}
