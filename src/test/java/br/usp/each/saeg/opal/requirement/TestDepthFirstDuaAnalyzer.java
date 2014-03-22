/**
 * OPAL - Open-source Program Analysis Library
 * Copyright (c) 2014 University of Sao Paulo
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

import static br.usp.each.saeg.opal.requirement.Util.contains;
import static br.usp.each.saeg.opal.requirement.Util.pdua;

import org.junit.Assert;
import org.junit.Test;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public class TestDepthFirstDuaAnalyzer {

    @Test
    public void testCorrectPUse() {
        final Graph<Block> g = new Graph<Block>();

        g.add(new Block(0));
        g.add(new Block(1));
        g.add(new Block(2));
        g.add(new Block(3));

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        g.get(0).def(0);
        g.get(1).def(0);
        g.get(1).puse(0);

        final Dua[] duas = new DepthFirstDuaAnalyzer().analyze(g, 1);

        Assert.assertEquals(2, duas.length);
        Assert.assertTrue(contains(pdua(1, 1, 2, 0), duas));
        Assert.assertTrue(contains(pdua(1, 1, 3, 0), duas));

        // Should not create definition-use associations
        // { 0, (1, 2), 0 } and { 0, (1, 3), 0 }
    }

}
