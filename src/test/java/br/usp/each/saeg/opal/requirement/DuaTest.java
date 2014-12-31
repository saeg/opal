/**
 * OPAL - Open-source Program Analysis Library
 * Copyright (c) 2014, 2015 University of Sao Paulo
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
