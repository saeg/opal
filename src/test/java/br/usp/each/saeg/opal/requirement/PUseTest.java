package br.usp.each.saeg.opal.requirement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.usp.each.saeg.opal.requirement.Use.Type;

public class PUseTest {

    private PUse puse;

    @Before
    public void setUp() {
        puse = new PUse(1, 2);
    }

    @Test
    public void testType() {
        Assert.assertEquals(Type.P_USE, puse.type);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(2, puse.id());
    }

    @Test
    public void testFrom() {
        Assert.assertEquals(1, puse.from);
    }

    @Test
    public void testTo() {
        Assert.assertEquals(2, puse.to);
    }

    @Test
    public void testEqualsASelfReturnTrue() {
        Assert.assertTrue(puse.equals(puse));
    }

    @Test
    public void testEqualsANullReturnFalse() {
        Assert.assertFalse(puse.equals(null));
    }

    @Test
    public void testEqualsDifferentClassReturnFalse() {
        Assert.assertFalse(puse.equals(1));
    }

    @Test
    public void testEqualsDifferentFromReturnFalse() {
        final PUse other = new PUse(3, 2);
        Assert.assertFalse(puse.equals(other));
    }

    @Test
    public void testEqualsDifferentToReturnFalse() {
        final PUse other = new PUse(1, 3);
        Assert.assertFalse(puse.equals(other));
    }

    @Test
    public void testEqualsReturnTrue() {
        final PUse other = new PUse(1, 2);
        Assert.assertTrue(puse.equals(other));
    }

    @Test
    public void testDifferentFromReturnOtherHashCode() {
        final PUse other = new PUse(3, 2);
        Assert.assertNotEquals(puse.hashCode(), other.hashCode());
    }

    @Test
    public void testDifferentToReturnOtherHashCode() {
        final PUse other = new PUse(1, 3);
        Assert.assertNotEquals(puse.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsReturnSameHashCode() {
        final PUse other = new PUse(1, 2);
        Assert.assertEquals(puse.hashCode(), other.hashCode());
    }

}
