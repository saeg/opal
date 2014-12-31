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
