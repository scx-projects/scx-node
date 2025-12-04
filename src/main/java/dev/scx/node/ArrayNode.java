package dev.scx.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/// ArrayNode
///
/// @author scx567888
/// @version 0.0.1
public final class ArrayNode implements ContainerNode, Iterable<Node> {

    private final List<Node> elements;

    public ArrayNode() {
        this.elements = new ArrayList<>();
    }

    public ArrayNode(int initialCapacity) {
        this.elements = new ArrayList<>(initialCapacity);
    }

    public void add(Node node) throws NullPointerException {
        if (node == null) {
            throw new NullPointerException("ArrayNode cannot add null");
        }
        elements.add(node);
    }

    public void add(int index, Node node) throws NullPointerException {
        if (node == null) {
            throw new NullPointerException("ArrayNode cannot add null");
        }
        elements.add(index, node);
    }

    public Node set(int index, Node node) throws NullPointerException {
        if (node == null) {
            throw new NullPointerException("ArrayNode cannot set null");
        }
        return elements.set(index, node);
    }

    public Node get(int index) {
        return elements.get(index);
    }

    public Node remove(int index) {
        return elements.remove(index);
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
        return elements.toString();
    }

}
