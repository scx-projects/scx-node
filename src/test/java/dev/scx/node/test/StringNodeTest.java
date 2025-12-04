package dev.scx.node.test;

import dev.scx.node.StringNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringNodeTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    @Test
    public static void test1() {
        // 测试相等性
        var n1 = new StringNode("hello");
        var n2 = new StringNode("hello");

        Assert.assertEquals(n1, n2);
    }

    @Test
    public static void test2() {
        // 测试 不可转换值
        var n = new StringNode("true");

        Assert.assertThrows(NumberFormatException.class, n::asInt);
        Assert.assertThrows(NumberFormatException.class, n::asIntExact);
        Assert.assertThrows(NumberFormatException.class, n::asLong);
        Assert.assertThrows(NumberFormatException.class, n::asLongExact);
        Assert.assertThrows(NumberFormatException.class, n::asFloat);
        Assert.assertThrows(NumberFormatException.class, n::asFloatExact);
        Assert.assertThrows(NumberFormatException.class, n::asDouble);
        Assert.assertThrows(NumberFormatException.class, n::asDoubleExact);
        Assert.assertThrows(NumberFormatException.class, n::asBigInteger);
        Assert.assertThrows(NumberFormatException.class, n::asBigIntegerExact);
        Assert.assertThrows(NumberFormatException.class, n::asBigDecimal);
        n.asString();
        n.asBoolean();
        n.deepCopy();
        n.toString();
    }

    @Test
    public static void test3() {
        // 测试 极小值 溢出
        var n = new StringNode("-1000.00001");

        Assert.assertEquals(n.asInt(), -1000);
        Assert.assertThrows(ArithmeticException.class, n::asIntExact);
        Assert.assertEquals(n.asLong(), -1000L);
        Assert.assertThrows(ArithmeticException.class, n::asLongExact);
        n.asFloat();
        Assert.assertThrows(ArithmeticException.class, n::asFloatExact);
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
        // 测试 极大值 溢出
        var n = new StringNode("9999999999999");

        n.asInt();
        Assert.assertThrows(ArithmeticException.class, n::asIntExact);
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
    public static void test5() {
        // 测试 正常值
        var n = new StringNode("200");

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
    public static void test6() {
        // 测试 正常值
        var n = new StringNode("200.0000");

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
