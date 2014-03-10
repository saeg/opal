package br.usp.each.saeg.opal.requirement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.usp.each.saeg.opal.requirement.Use.Type;

public class CUseTest {

    private CUse cuse;

    @Before
    public void setUp() {
        cuse = new CUse(1);
    }

    @Test
    public void testType() {
        Assert.assertEquals(Type.C_USE, cuse.type);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(1, cuse.id());
    }

    @Test
    public void testId() {
        Assert.assertEquals(1, cuse.id);
    }

    @Test
    public void testEqualsASelfReturnTrue() {
        Assert.assertTrue(cuse.equals(cuse));
    }

    @Test
    public void testEqualsANullReturnFalse() {
        Assert.assertFalse(cuse.equals(null));
    }

    @Test
    public void testEqualsDifferentClassReturnFalse() {
        Assert.assertFalse(cuse.equals(1));
    }

    @Test
    public void testEqualsDifferentIdReturnFalse() {
        final CUse other = new CUse(2);
        Assert.assertFalse(cuse.equals(other));
    }

    @Test
    public void testEqualsReturnTrue() {
        final CUse other = new CUse(1);
        Assert.assertTrue(cuse.equals(other));
    }

    @Test
    public void testDifferentIdReturnOtherHashCode() {
        final CUse other = new CUse(2);
        Assert.assertNotEquals(cuse.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsReturnSameHashCode() {
        final CUse other = new CUse(1);
        Assert.assertEquals(cuse.hashCode(), other.hashCode());
    }

}
