package dev.scx.node;

/// Node
///
/// ### 一个中立的, 平台无关的 通用树形数据模型.
///
/// 作为顶层接口, 不提供任何 如 `isNull`, `isArray`, 'isValue' 之类的类型判断方法, 因为这些方法即使存在, 也仍需强转才能使用, 意义不大.
/// 同时也不提供任何 `asInt`, `asLong`, `asBoolean` 之类的数值转换方法. 因为这些并不是所有 Node 都存在的功能. 强行提供会导致语义混淆.
///
/// @author scx567888
/// @version 0.0.1
public sealed interface Node permits ValueNode, ArrayNode, ObjectNode, NullNode {

    /// 深拷贝, 本质上只有 [ArrayNode] 和 [ObjectNode] 才存在这个概念.
    /// 但是为了使用便利性, 这里提升到 最顶层 Node 接口中.
    /// - [ArrayNode] / [ObjectNode] 会返回结构完全独立的副本.
    /// - [ValueNode] / [NullNode] 返回自身(不可变节点, 无需复制).
    Node deepCopy();

}
