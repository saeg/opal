package br.usp.each.saeg.opal.requirement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    private Node node;

    @Before
    public void setUp() {
        node = new Node(1);
    }

    @Test
    public void testId() {
        Assert.assertEquals(1, node.id);
    }

    @Test
    public void testEqualsASelfReturnTrue() {
        Assert.assertTrue(node.equals(node));
    }

    @Test
    public void testEqualsANullReturnFalse() {
        Assert.assertFalse(node.equals(null));
    }

    @Test
    public void testEqualsDifferentClassReturnFalse() {
        Assert.assertFalse(node.equals(1));
    }

    @Test
    public void testEqualsDifferentIdReturnFalse() {
        final Node other = new Node(2);
        Assert.assertFalse(node.equals(other));
    }

    @Test
    public void testEqualsReturnTrue() {
        final Node other = new Node(1);
        Assert.assertTrue(node.equals(other));
    }

    @Test
    public void testDifferentIdReturnOtherHashCode() {
        final Node other = new Node(2);
        Assert.assertNotEquals(node.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsReturnSameHashCode() {
        final Node other = new Node(1);
        Assert.assertEquals(node.hashCode(), other.hashCode());
    }

}
