package dev.scx.node.test;

import dev.scx.node.ArrayNode;
import dev.scx.node.IntNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayNodeTest {

    public static void main(String[] args) {
        test1();
    }

    @Test
    public static void test1() {
        var a = new ArrayNode();
        a.add(100);
        a.add(125);
        a.add(200);
        a.add(new IntNode(300));
        Assert.assertEquals(a.get(0), new IntNode(100));
        Assert.assertEquals(a.get(1), new IntNode(125));
        Assert.assertEquals(a.get(2), new IntNode(200));
        Assert.assertEquals(a.get(3), new IntNode(300));
        Assert.assertEquals(a.size(), 4);
        // 测试循环
        for (var v : a) {
            Assert.assertNotNull(v);
        }
        a.clear();
        Assert.assertEquals(a.size(), 0);
    }

}
