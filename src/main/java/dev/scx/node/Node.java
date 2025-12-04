package dev.scx.node;

/// 一套中立的, 平台无关的 通用数据模型.
///
/// @author scx567888
/// @version 0.0.1
public sealed interface Node permits ValueNode, ContainerNode, NullNode {

    /// 深拷贝, 本质上只有 [ContainerNode] 才存在这个概念.
    /// 但是为了使用便利性, 这里提升到 最顶层 Node 接口中.
    /// - [ContainerNode] 会返回结构完全独立的副本.
    /// - [ValueNode] / [NullNode] 返回自身(不可变节点, 无需复制).
    Node deepCopy();

}
