package dev.scx.node.test;

import dev.scx.node.DoubleNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleNodeTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    @Test
    public static void test1() {
        // 测试相等性
        var n1 = new DoubleNode(5678.8765F);
        var n2 = new DoubleNode(5678.8765F);

        Assert.assertEquals(n1, n2);
    }

    @Test
    public static void test2() {
        // 测试 正常值溢出
        var n = new DoubleNode(9999.9999F);

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
        var n = new DoubleNode(Double.MIN_VALUE + 1.01F);

        n.asInt();
        Assert.assertThrows(ArithmeticException.class, n::asIntExact);
        n.asLong();
        Assert.assertThrows(ArithmeticException.class, n::asLongExact);
        n.asFloat();
        n.asFloatExact();
        n.asDouble();
        n.asDoubleExact();
        n.asBigInteger();
        Assert.assertThrows(ArithmeticException.class, n::asBigIntegerExact);
        n.asBigDecimal();
        n.asString();
        n.asBoolean();
        n.deepCopy();
        n.toString();
    }

    @Test
    public static void test4() {
        // 测试 不 溢出
        var n = new DoubleNode(200);

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

}
