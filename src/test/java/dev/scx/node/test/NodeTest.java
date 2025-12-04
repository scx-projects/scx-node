package dev.scx.node.test;

import dev.scx.node.IntNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NodeTest {

    public static void main(String[] args) throws Throwable {
        testInt();
    }

    @Test
    public static void testInt() {

        var n1 = new IntNode(5678);
        var n2 = new IntNode(5678);

        Assert.assertEquals(n1, n2);
    }

}
