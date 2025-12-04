package dev.scx.node;

/// ValueNode
///
/// @author scx567888
/// @version 0.0.1
public sealed interface ValueNode extends Node permits NumberNode, StringNode, BooleanNode, BinaryNode {

    @Override
    ValueNode deepCopy();

}
