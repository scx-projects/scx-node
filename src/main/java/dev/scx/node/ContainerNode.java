package dev.scx.node;

/// ContainerNode
///
/// @author scx567888
public sealed interface ContainerNode extends Node permits ArrayNode, ObjectNode {

    int size();

    boolean isEmpty();

    void clear();

    @Override
    ContainerNode deepCopy();

}
