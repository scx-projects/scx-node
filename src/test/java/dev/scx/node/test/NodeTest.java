package dev.scx.node.test;

import dev.scx.node.IntNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NodeTest {

    public static void main(String[] args) throws Throwable {
        test1();
    }

    @Test
    public static void test1() {

        var n1 = new IntNode(5678);
        var n2 = new IntNode(5678);

        Assert.assertEquals(n1, n2);
    }

}
