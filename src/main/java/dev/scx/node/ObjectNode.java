package dev.scx.node;

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

    public Node put(String name, Node value) {
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
    public boolean equals(Object object) {
        if (object instanceof ObjectNode objectNode) {
            return fields.equals(objectNode.fields);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return fields.hashCode();
    }

    @Override
    public String toString() {
        return fields.toString();
    }

}
