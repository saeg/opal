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
