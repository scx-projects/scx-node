package dev.scx.node;

/// BinaryNode
///
/// @author scx567888
/// @version 0.0.1
public record BinaryNode(byte[] value) implements ValueNode {

    public BinaryNode {
        if (value == null) {
            throw new NullPointerException("BinaryNode value cannot be null");
        }
    }

    @Override
    public ValueNode deepCopy() {
        return this;
    }

}
