package dev.scx.node.test;

import dev.scx.node.BigDecimalNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BigDecimalNodeTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    @Test
    public static void test1() {
        // 测试相等性
        var n1 = new BigDecimalNode(BigDecimal.valueOf(5678.8765));
        var n2 = new BigDecimalNode(BigDecimal.valueOf(5678.8765));

        Assert.assertEquals(n1, n2);
    }

    @Test
    public static void test2() {
        // 测试 正常值溢出
        var n = new BigDecimalNode(BigDecimal.valueOf(9999.9999));

        n.asInt();
        Assert.assertThrows(ArithmeticException.class, n::asIntExact);
        n.asLong();
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
    public static void test3() {
        // 测试 极小值 溢出
        var n = new BigDecimalNode(BigDecimal.valueOf(Double.MIN_VALUE + 1.01));

        n.asInt();
        Assert.assertThrows(ArithmeticException.class, n::asIntExact);
        n.asLong();
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
        // 测试 不 溢出
        var n = new BigDecimalNode(BigDecimal.valueOf(200));

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
    public static void test5() {
        // 测试 不 溢出
        var n = new BigDecimalNode(BigDecimal.valueOf(200.00));

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
