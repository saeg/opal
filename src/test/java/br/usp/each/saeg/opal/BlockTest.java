package br.usp.each.saeg.opal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlockTest {

    private Block block;

    @Before
    public void setUp() {
        block = new Block(1);
    }

    @Test
    public void testId() {
        Assert.assertEquals(1, block.id);
    }

    @Test
    public void testNewlyCreatedBlockHaveAllSetsEmpty() {
        Assert.assertFalse(block.defs().hasNext());
        Assert.assertFalse(block.cuses().hasNext());
        Assert.assertFalse(block.puses().hasNext());
        Assert.assertTrue(block.lines().isEmpty());
    }

    @Test
    public void testDef() {
        Assert.assertFalse(block.isDef(1));
        block.def(1);
        Assert.assertTrue(block.isDef(1));
    }

    @Test
    public void testCUse() {
        Assert.assertFalse(block.isCUse(1));
        block.cuse(1);
        Assert.assertTrue(block.isCUse(1));
    }

    @Test
    public void testPUse() {
        Assert.assertFalse(block.isPUse(1));
        block.puse(1);
        Assert.assertTrue(block.isPUse(1));
    }

    @Test
    public void testLines() {
        Assert.assertFalse(block.isLine(1));
        block.line(1);
        Assert.assertTrue(block.isLine(1));
    }

    @Test
    public void testClone() {
        block.def(0);
        block.cuse(1);
        block.puse(2);
        block.line(3);
        final Block clone = block.clone();
        Assert.assertTrue(clone.isDef(0));
        Assert.assertTrue(clone.isCUse(1));
        Assert.assertTrue(clone.isPUse(2));
        Assert.assertTrue(clone.isLine(3));
        Assert.assertEquals(1, clone.defs().size());
        Assert.assertEquals(1, clone.cuses().size());
        Assert.assertEquals(1, clone.puses().size());
        Assert.assertEquals(1, clone.lines().size());
    }

}
