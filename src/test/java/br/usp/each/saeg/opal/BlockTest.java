/**
 * OPAL - Open-source Program Analysis Library
 * Copyright (c) 2014, 2016 University of Sao Paulo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
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
