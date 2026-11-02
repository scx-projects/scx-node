package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/// ArrayNode
///
/// @author scx567888
public final class ArrayNode implements ContainerNode, Iterable<Node> {

    private final List<Node> elements;

    public ArrayNode() {
        this.elements = new ArrayList<>();
    }

    public ArrayNode(int initialCapacity) throws IllegalArgumentException {
        this.elements = new ArrayList<>(initialCapacity);
    }

    /// 在末尾添加 Node.
    public void add(Node node) throws NullPointerException {
        if (node == null) {
            throw new NullPointerException("ArrayNode element cannot be null");
        }
        elements.add(node);
    }

    /// 在指定索引处插入 Node, 索引越界时抛出 [IndexOutOfBoundsException].
    public void add(int index, Node node) throws NullPointerException, IndexOutOfBoundsException {
        if (node == null) {
            throw new NullPointerException("ArrayNode element cannot be null");
        }
        elements.add(index, node);
    }

    /// 替换指定索引处的 Node, 并返回原 Node, 索引越界时抛出 [IndexOutOfBoundsException].
    public Node set(int index, Node node) throws NullPointerException, IndexOutOfBoundsException {
        if (node == null) {
            throw new NullPointerException("ArrayNode element cannot be null");
        }
        return elements.set(index, node);
    }

    /// 获取指定索引处的 Node, 不存在时返回 null.
    public Node get(int index) {
        try {
            return elements.get(index);
        } catch (IndexOutOfBoundsException ignored) {
            return null;
        }
    }

    /// 移除并返回指定索引处的 Node, 不存在时返回 null.
    public Node remove(int index) {
        try {
            return elements.remove(index);
        } catch (IndexOutOfBoundsException ignored) {
            return null;
        }
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public Iterator<Node> iterator() {
        return elements.iterator();
    }

    @Override
    public ArrayNode deepCopy() {
        // 这里假设 ArrayNode 不存在自引用
        var arrayNode = new ArrayNode(size());
        for (var element : this) {
            arrayNode.add(element.deepCopy());
        }
        return arrayNode;
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ArrayNode arrayNode) {
            return elements.equals(arrayNode.elements);
        }
        return false;
    }

    @Override
    public String toString() {
        // 采用 JSON 格式
        // 这里假设 ArrayNode 不存在自引用
        return toString0(0);
    }

    /// 内部方法
    String toString0(int indentLevel) {
        // 采用 JSON 格式
        // 这里假设 ArrayNode 不存在自引用
        if (elements.isEmpty()) {
            return "[]";
        }

        var sb = new StringBuilder();
        sb.append("[\n");

        var size = elements.size();
        var index = 0;
        for (var element : elements) {
            // 缩进单位 2 个空格.
            sb.append("  ".repeat(indentLevel + 1));

            // 添加 值
            var v = switch (element) {
                case ArrayNode arrayNode -> arrayNode.toString0(indentLevel + 1);
                case ObjectNode objectNode -> objectNode.toString0(indentLevel + 1);
                default -> element.toString();
            };
            sb.append(v);

            // 如果不是最后一个元素, 加逗号
            if (index != size - 1) {
                sb.append(",");
            }
            sb.append("\n");
            index = index + 1;
        }

        // 当前层缩进
        sb.append("  ".repeat(indentLevel));
        // 尾部
        sb.append("]");
        return sb.toString();
    }

    // ******************** 简易方法 ********************

    public void add(int value) {
        elements.add(new IntNode(value));
    }

    public void add(long value) {
        elements.add(new LongNode(value));
    }

    public void add(float value) {
        elements.add(new FloatNode(value));
    }

    public void add(double value) {
        elements.add(new DoubleNode(value));
    }

    public void add(BigInteger value) throws NullPointerException {
        elements.add(new BigIntegerNode(value));
    }

    public void add(BigDecimal value) throws NullPointerException {
        elements.add(new BigDecimalNode(value));
    }

    public void add(String value) throws NullPointerException {
        elements.add(new StringNode(value));
    }

    public void add(boolean value) {
        elements.add(BooleanNode.of(value));
    }

    public void add(int index, int value) throws IndexOutOfBoundsException {
        elements.add(index, new IntNode(value));
    }

    public void add(int index, long value) throws IndexOutOfBoundsException {
        elements.add(index, new LongNode(value));
    }

    public void add(int index, float value) throws IndexOutOfBoundsException {
        elements.add(index, new FloatNode(value));
    }

    public void add(int index, double value) throws IndexOutOfBoundsException {
        elements.add(index, new DoubleNode(value));
    }

    public void add(int index, BigInteger value) throws NullPointerException, IndexOutOfBoundsException {
        elements.add(index, new BigIntegerNode(value));
    }

    public void add(int index, BigDecimal value) throws NullPointerException, IndexOutOfBoundsException {
        elements.add(index, new BigDecimalNode(value));
    }

    public void add(int index, String value) throws NullPointerException, IndexOutOfBoundsException {
        elements.add(index, new StringNode(value));
    }

    public void add(int index, boolean value) throws IndexOutOfBoundsException {
        elements.add(index, BooleanNode.of(value));
    }

    public Node set(int index, int value) throws IndexOutOfBoundsException {
        return elements.set(index, new IntNode(value));
    }

    public Node set(int index, long value) throws IndexOutOfBoundsException {
        return elements.set(index, new LongNode(value));
    }

    public Node set(int index, float value) throws IndexOutOfBoundsException {
        return elements.set(index, new FloatNode(value));
    }

    public Node set(int index, double value) throws IndexOutOfBoundsException {
        return elements.set(index, new DoubleNode(value));
    }

    public Node set(int index, BigInteger value) throws NullPointerException, IndexOutOfBoundsException {
        return elements.set(index, new BigIntegerNode(value));
    }

    public Node set(int index, BigDecimal value) throws NullPointerException, IndexOutOfBoundsException {
        return elements.set(index, new BigDecimalNode(value));
    }

    public Node set(int index, String value) throws NullPointerException, IndexOutOfBoundsException {
        return elements.set(index, new StringNode(value));
    }

    public Node set(int index, boolean value) throws IndexOutOfBoundsException {
        return elements.set(index, BooleanNode.of(value));
    }

}
