package dev.scx.node.test;

import dev.scx.node.IntNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntNodeTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    @Test
    public static void test1() {
        // 测试相等性
        var n1 = new IntNode(5678);
        var n2 = new IntNode(5678);

        Assert.assertEquals(n1, n2);
    }

    @Test
    public static void test2() {
        // 测试 正常值溢出
        var n = new IntNode(9999);

        n.asInt();
        n.asIntExact();
        n.asLong();
        n.asLongExact();
        n.asFloat();
        n.asFloatExact();
        n.asDouble();
        n.asDoubleExact();
        n.asBigInteger();
        n.asBigIntegerExact();
        n.asBigDecimal();
        n.asString();
        n.asBoolean();
        n.deepCopy();
        n.toString();
    }

    @Test
    public static void test3() {
        // 测试 极小值 溢出
        var n = new IntNode(Integer.MIN_VALUE + 1);

        n.asInt();
        n.asIntExact();
        n.asLong();
        n.asLongExact();
        n.asFloat();
        Assert.assertThrows(ArithmeticException.class, n::asFloatExact);
        n.asDouble();
        n.asDoubleExact();
        n.asBigInteger();
        n.asBigIntegerExact();
        n.asBigDecimal();
        n.asString();
        n.asBoolean();
        n.deepCopy();
        n.toString();
    }

    @Test
    public static void test4() {
        // 测试 极大值 溢出
        var n = new IntNode(Integer.MAX_VALUE - 1);

        n.asInt();
        n.asIntExact();
        n.asLong();
        n.asLongExact();
        n.asFloat();
        Assert.assertThrows(ArithmeticException.class, n::asFloatExact);
        n.asDouble();
        n.asDoubleExact();
        n.asBigInteger();
        n.asBigIntegerExact();
        n.asBigDecimal();
        n.asString();
        n.asBoolean();
        n.deepCopy();
        n.toString();
    }

}
