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

import static br.usp.each.saeg.commons.ArrayUtils.contains;

import org.junit.Assert;
import org.junit.Test;

public class UseTest {

    @Test
    public void testCastPUse() {
        final Use use = new PUse(0, 0);
        Exception exception = null;
        try {
            use.puse();
        } catch (final ClassCastException e) {
            exception = e;
        }
        Assert.assertNull(exception);
    }

    @Test
    public void testCastCUse() {
        final Use use = new CUse(0);
        Exception exception = null;
        try {
            use.cuse();
        } catch (final ClassCastException e) {
            exception = e;
        }
        Assert.assertNull(exception);
    }

    @Test(expected = ClassCastException.class)
    public void testCastPUseThrowsException() {
        new PUse(0, 0).cuse();
    }

    @Test(expected = ClassCastException.class)
    public void testCastCUseThrowsException() {
        new CUse(0).puse();
    }

    @Test
    public void testUseType() {
        // tests just to increase coverage
        final Use.Type[] types = Use.Type.values();
        Assert.assertTrue(contains(types, Use.Type.C_USE));
        Assert.assertTrue(contains(types, Use.Type.P_USE));
        Assert.assertEquals(2, types.length);
        Assert.assertEquals(Use.Type.C_USE, Use.Type.valueOf("C_USE"));
        Assert.assertEquals(Use.Type.P_USE, Use.Type.valueOf("P_USE"));
    }

}
