package dev.scx.node.test;

import dev.scx.node.IntNode;
import dev.scx.node.ObjectNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObjectNodeTest {

    public static void main(String[] args) {
        test1();
    }

    @Test
    public static void test1() {
        var a = new ObjectNode();
        a.put("0", 100);
        a.put("1", 125);
        a.put("2", 200);
        a.put("3", new IntNode(300));
        Assert.assertEquals(a.get("0"), new IntNode(100));
        Assert.assertEquals(a.get("1"), new IntNode(125));
        Assert.assertEquals(a.get("2"), new IntNode(200));
        Assert.assertEquals(a.get("3"), new IntNode(300));
        Assert.assertEquals(a.size(), 4);
        // 测试循环
        for (var v : a) {
            Assert.assertNotNull(v.getKey());
            Assert.assertNotNull(v.getValue());
        }
        a.clear();
        Assert.assertEquals(a.size(), 0);
    }

}
