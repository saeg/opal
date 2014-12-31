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

public class EdgeTest {

    private Edge edge;

    @Before
    public void setUp() {
        edge = new Edge(1, 2);
    }

    @Test
    public void testFrom() {
        Assert.assertEquals(1, edge.from);
    }

    @Test
    public void testTo() {
        Assert.assertEquals(2, edge.to);
    }

    @Test
    public void testEqualsASelfReturnTrue() {
        Assert.assertTrue(edge.equals(edge));
    }

    @Test
    public void testEqualsANullReturnFalse() {
        Assert.assertFalse(edge.equals(null));
    }

    @Test
    public void testEqualsDifferentClassReturnFalse() {
        Assert.assertFalse(edge.equals(1));
    }

    @Test
    public void testEqualsDifferentFromReturnFalse() {
        final Edge other = new Edge(3, 2);
        Assert.assertFalse(edge.equals(other));
    }

    @Test
    public void testEqualsDifferentToReturnFalse() {
        final Edge other = new Edge(1, 3);
        Assert.assertFalse(edge.equals(other));
    }

    @Test
    public void testEqualsReturnTrue() {
        final Edge other = new Edge(1, 2);
        Assert.assertTrue(edge.equals(other));
    }

    @Test
    public void testDifferentFromReturnOtherHashCode() {
        final Edge other = new Edge(3, 2);
        Assert.assertNotEquals(edge.hashCode(), other.hashCode());
    }

    @Test
    public void testDifferentToReturnOtherHashCode() {
        final Edge other = new Edge(1, 3);
        Assert.assertNotEquals(edge.hashCode(), other.hashCode());
    }

    @Test
    public void testEqualsReturnSameHashCode() {
        final Edge other = new Edge(1, 2);
        Assert.assertEquals(edge.hashCode(), other.hashCode());
    }

}
