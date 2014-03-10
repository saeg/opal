package br.usp.each.saeg.opal.requirement;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DuaTest {

    private Dua dua;
    private Use use;

    @Before
    public void setUp() {
        use = mock(Use.class);
        dua = new Dua(1, use, 2);
    }

    @Test
    public void testDef() {
        Assert.assertEquals(1, dua.def);
    }

    @Test
    public void testUse() {
        Assert.assertEquals(use, dua.use);
    }

    @Test
    public void testVar() {
        Assert.assertEquals(2, dua.var);
    }

    @Test
    public void testEqualsASelfReturnTrue() {
        Assert.assertTrue(dua.equals(dua));
    }

    @Test
    public void testEqualsANullReturnFalse() {
        Assert.assertFalse(dua.equals(null));
    }

    @Test
    public void testEqualsDifferentClassReturnFalse() {
        Assert.assertFalse(dua.equals(1));
    }

    @Test
    public void testEqualsDifferentDefReturnFalse() {
        final Dua other = new Dua(3, use, 2);
        Assert.assertFalse(dua.equals(other));
    }

    @Test
    public void testEqualsDifferentVarReturnFalse() {
        final Dua other = new Dua(1, use, 3);
        Assert.assertFalse(dua.equals(other));
    }

    @Test
    public void testEqualsDifferentUseReturnFalse() {
        final Dua other = new Dua(1, mock(Use.class), 2);
        Assert.assertFalse(dua.equals(other));
    }

    @Test
    public void testEqualsReturnTrue() {
        final Dua other = new Dua(1, use, 2);
        Assert.assertTrue(dua.equals(other));
    }

    @Test
    public void testDifferentDefReturnOtherHashCode() {
        final Dua other = new Dua(3, use, 2);
        Assert.assertNotEquals(dua.hashCode(), other.hashCode());
    }

    @Test
    public void testDifferentUseReturnOtherHashCode() {
        final Dua other = new Dua(1, mock(Use.class), 2);
        Assert.assertNotEquals(dua.hashCode(), other.hashCode());
    }

    @Test
    public void testDifferentVarReturnOtherHashCode() {
        final Dua other = new Dua(1, use, 3);
        Assert.assertNotEquals(dua.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsReturnSameHashCode() {
        final Dua other = new Dua(1, use, 2);
        Assert.assertEquals(dua.hashCode(), other.hashCode());
    }

}
