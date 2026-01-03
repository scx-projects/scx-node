package dev.scx.node;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/// ObjectNode
///
/// @author scx567888
/// @version 0.0.1
public final class ObjectNode implements ContainerNode, Iterable<Map.Entry<String, Node>> {

    private final Map<String, Node> fields;

    public ObjectNode() {
        this.fields = new LinkedHashMap<>();
    }

    public ObjectNode(int initialCapacity) {
        this.fields = new LinkedHashMap<>(initialCapacity);
    }

    public Node put(String name, Node value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        if (value == null) {
            throw new NullPointerException("ObjectNode cannot put null value");
        }
        return fields.put(name, value);
    }

    public Node get(String name) {
        return fields.get(name);
    }

    public Node remove(String name) {
        return fields.remove(name);
    }

    @Override
    public int size() {
        return fields.size();
    }

    @Override
    public boolean isEmpty() {
        return fields.isEmpty();
    }

    @Override
    public void clear() {
        fields.clear();
    }

    @Override
    public Iterator<Map.Entry<String, Node>> iterator() {
        return fields.entrySet().iterator();
    }

    @Override
    public ObjectNode deepCopy() {
        // 这里假设 ObjectNode 不存在自引用
        var objectNode = new ObjectNode(size());
        for (var field : this) {
            objectNode.put(field.getKey(), field.getValue().deepCopy());
        }
        return objectNode;
    }

    @Override
    public int hashCode() {
        return fields.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ObjectNode objectNode) {
            return fields.equals(objectNode.fields);
        }
        return false;
    }

    @Override
    public String toString() {
        // 采用 JSON 格式
        // 这里假设 ObjectNode 不存在自引用
        return toString0(0);
    }

    /// 内部方法
    String toString0(int indentLevel) {
        // 采用 JSON 格式
        // 这里假设 ObjectNode 不存在自引用
        if (fields.isEmpty()) {
            return "{}";
        }

        var sb = new StringBuilder();
        sb.append("{\n");

        var size = fields.size();
        var index = 0;
        for (var field : fields.entrySet()) {
            // 缩进单位 2 个空格.
            sb.append("  ".repeat(indentLevel + 1));

            // 添加 key
            sb.append("\"").append(field.getKey()).append("\"");
            // 添加分隔符
            sb.append(": ");

            var element = field.getValue();
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
        sb.append("}");
        return sb.toString();
    }

    //*************** 简易方法 ********************

    public Node put(String name, int value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, new IntNode(value));
    }

    public Node put(String name, long value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, new LongNode(value));
    }

    public Node put(String name, float value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, new FloatNode(value));
    }

    public Node put(String name, double value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, new DoubleNode(value));
    }

    public Node put(String name, BigInteger value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, new BigIntegerNode(value));
    }

    public Node put(String name, BigDecimal value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, new BigDecimalNode(value));
    }

    public Node put(String name, String value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, new StringNode(value));
    }

    public Node put(String name, boolean value) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("ObjectNode cannot put null name");
        }
        return fields.put(name, BooleanNode.of(value));
    }

}
