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

public class GraphTest {

    public static class Id implements Identifiable {

        private final int id;

        public Id(final int id) {
            this.id = id;
        }

        @Override
        public int id() {
            return id;
        }

    }

    private static final Id ONE = new Id(1);
    private static final Id TWO = new Id(2);

    private IGraph<Id> graph;

    @Before
    public void setUp() {
        graph = new Graph<Id>();
    }

    @Test
    public void testAddNode() {
        Assert.assertTrue(graph.add(ONE));
    }

    @Test
    public void testAddDuplicatedNode() {
        graph.add(ONE);
        Assert.assertFalse(graph.add(ONE));
    }

    @Test
    public void testAddEdge() {
        graph.add(ONE);
        graph.add(TWO);
        Assert.assertTrue(graph.addEdge(1, 2));
    }

    @Test
    public void testAddDuplicatedEdge() {
        graph.add(ONE);
        graph.add(TWO);
        graph.addEdge(1, 2);
        Assert.assertFalse(graph.addEdge(1, 2));
    }

    @Test
    public void testAddEdgeWithInvalidFromNode() {
        graph.add(ONE);
        Assert.assertFalse(graph.addEdge(0, 1));
    }

    @Test
    public void testAddEdgeWithInvalidToNode() {
        graph.add(ONE);
        Assert.assertFalse(graph.addEdge(1, 0));
    }

    @Test
    public void testGetNode() {
        graph.add(ONE);
        Assert.assertEquals(1, graph.get(1).id);
    }

    @Test
    public void testGetInvalidNode() {
        Assert.assertNull(graph.get(1));
    }

    @Test
    public void testRemoveNode() {
        graph.add(ONE);
        Assert.assertTrue(graph.remove(1));
    }

    @Test
    public void testRemoveInvalidNode() {
        Assert.assertFalse(graph.remove(1));
    }

    @Test
    public void testRemoveNodeWithOutEdges() {
        graph.add(ONE);
        graph.add(TWO);
        graph.addEdge(1, 2);
        Assert.assertFalse(graph.remove(1));
    }

    @Test
    public void testRemoveNodeWithInEdges() {
        graph.add(ONE);
        graph.add(TWO);
        graph.addEdge(1, 2);
        Assert.assertFalse(graph.remove(2));
    }

    @Test
    public void testRemoveEdge() {
        graph.add(ONE);
        graph.add(TWO);
        graph.addEdge(1, 2);
        Assert.assertTrue(graph.removeEdge(1, 2));
    }

    @Test
    public void testRemoveEdgeWithInvalidFromNode() {
        graph.add(ONE);
        Assert.assertFalse(graph.removeEdge(0, 1));
    }

    @Test
    public void testRemoveEdgeWithInvalidToNode() {
        graph.add(ONE);
        Assert.assertFalse(graph.removeEdge(1, 0));
    }

    @Test
    public void testAdjacent() {
        graph.add(ONE);
        graph.add(TWO);
        graph.addEdge(1, 2);
        Assert.assertTrue(graph.adjacent(1, 2));
    }

    @Test
    public void testAdjacentWithInvalidFromNode() {
        graph.add(ONE);
        Assert.assertFalse(graph.adjacent(0, 1));
    }

    @Test
    public void testAdjacentWithInvalidToNode() {
        graph.add(ONE);
        Assert.assertFalse(graph.adjacent(1, 0));
    }

    @Test
    public void testNoNeighbors() {
        graph.add(ONE);
        Assert.assertTrue(graph.neighbors(1).isEmpty());
    }

    @Test
    public void testNeighbors() {
        graph.add(ONE);
        graph.add(TWO);
        graph.addEdge(1, 2);
        Assert.assertTrue(graph.neighbors(1).contains(TWO));
        Assert.assertEquals(1, graph.neighbors(1).size());
    }

    @Test
    public void testNeighborsInvalidNode() {
        Assert.assertNull(graph.neighbors(1));
    }

    @Test
    public void testInitialGraphSize() {
        Assert.assertEquals(0, graph.size());
    }

    @Test
    public void testSizeIncrease() {
        graph.add(ONE);
        Assert.assertEquals(1, graph.size());
    }

    @Test
    public void testSizeDecrease() {
        graph.add(ONE);
        graph.remove(1);
        Assert.assertEquals(0, graph.size());
    }

    @Test
    public void testInverseNode() {
        graph.add(ONE);
        final IGraph<Id> inverse = graph.inverse();
        Assert.assertFalse(inverse.add(ONE));
        Assert.assertEquals(1, inverse.size());
        Assert.assertTrue(inverse.neighbors(1).isEmpty());
    }

    @Test
    public void testInverseEdge() {
        graph.add(ONE);
        graph.add(TWO);
        graph.addEdge(1, 2);
        final IGraph<Id> inverse = graph.inverse();
        Assert.assertFalse(inverse.add(ONE));
        Assert.assertFalse(inverse.add(TWO));
        Assert.assertFalse(inverse.addEdge(2, 1));
        Assert.assertEquals(2, inverse.size());
        Assert.assertTrue(inverse.neighbors(2).contains(ONE));
        Assert.assertEquals(1, inverse.neighbors(2).size());
        Assert.assertTrue(inverse.neighbors(1).isEmpty());
    }

}
