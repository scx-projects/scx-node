package dev.scx.node;

/// NumberNode
///
/// @author scx567888
/// @version 0.0.1
public sealed interface NumberNode extends ValueNode permits IntNode, LongNode, FloatNode, DoubleNode, BigIntegerNode, BigDecimalNode {

    @Override
    NumberNode deepCopy();

}
