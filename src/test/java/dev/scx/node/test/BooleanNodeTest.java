package dev.scx.node.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static dev.scx.node.BooleanNode.FALSE;
import static dev.scx.node.BooleanNode.TRUE;

public class BooleanNodeTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    @Test
    public static void test1() {
        var n = TRUE;

        Assert.assertEquals(n.asInt(), 1);
        Assert.assertEquals(n.asIntExact(), 1);
        Assert.assertEquals(n.asLong(), 1);
        Assert.assertEquals(n.asLongExact(), 1);
        Assert.assertEquals(n.asFloat(), 1);
        Assert.assertEquals(n.asFloatExact(), 1);
        Assert.assertEquals(n.asDouble(), 1);
        Assert.assertEquals(n.asDoubleExact(), 1);
        Assert.assertEquals(n.asBigInteger(), BigInteger.ONE);
        Assert.assertEquals(n.asBigIntegerExact(), BigInteger.ONE);
        Assert.assertEquals(n.asBigDecimal(), BigDecimal.ONE);
        Assert.assertEquals(n.asString(), "true");
        Assert.assertEquals(n.asBoolean(), true);
        Assert.assertEquals(n.deepCopy(), TRUE);
        Assert.assertEquals(n.toString(), "true");
    }

    @Test
    public static void test2() {
        var n = FALSE;

        Assert.assertEquals(n.asInt(), 0);
        Assert.assertEquals(n.asIntExact(), 0);
        Assert.assertEquals(n.asLong(), 0);
        Assert.assertEquals(n.asLongExact(), 0);
        Assert.assertEquals(n.asFloat(), 0);
        Assert.assertEquals(n.asFloatExact(), 0);
        Assert.assertEquals(n.asDouble(), 0);
        Assert.assertEquals(n.asDoubleExact(), 0);
        Assert.assertEquals(n.asBigInteger(), BigInteger.ZERO);
        Assert.assertEquals(n.asBigIntegerExact(), BigInteger.ZERO);
        Assert.assertEquals(n.asBigDecimal(), BigDecimal.ZERO);
        Assert.assertEquals(n.asString(), "false");
        Assert.assertEquals(n.asBoolean(), false);
        Assert.assertEquals(n.deepCopy(), FALSE);
        Assert.assertEquals(n.toString(), "false");
    }

}
