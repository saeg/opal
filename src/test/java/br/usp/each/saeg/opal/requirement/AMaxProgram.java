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

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public abstract class AMaxProgram {

    private Graph<Block> graph;

    private Map<String, Integer> variables;

    @Before
    public void setUp() {
        graph = new Graph<Block>();
        variables = new HashMap<String, Integer>();

        final Block b0 = new Block(0);
        final Block b1 = new Block(1);
        final Block b2 = new Block(2);
        final Block b3 = new Block(3);
        final Block b4 = new Block(4);
        final Block b5 = new Block(5);

        graph.add(b0);
        graph.add(b1);
        graph.add(b2);
        graph.add(b3);
        graph.add(b4);
        graph.add(b5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        variables.put("array", 0);
        variables.put("length", 1);
        variables.put("i", 2);
        variables.put("max", 3);

        /*
         * public static int max(int[] array, int length) int i = 0 int max = array[i++]
         */
        b0.def(variable("array"));
        b0.def(variable("length"));
        b0.def(variable("i"));
        b0.def(variable("max"));

        // while (i < length)
        b1.puse(variable("i"));
        b1.puse(variable("length"));

        // if (array[i] > max)
        b2.puse(variable("array"));
        b2.puse(variable("i"));
        b2.puse(variable("max"));

        // max = array[i]
        b3.def(variable("max"));
        b3.cuse(variable("array"));
        b3.cuse(variable("i"));

        // i = i + 1
        b4.def(variable("i"));
        b4.cuse(variable("i"));

        // return max
        b5.cuse(variable("max"));
    }

    public Graph<Block> getGraph() {
        return graph;
    }

    public int variable(final String name) {
        return variables.get(name);
    }

    public int numOfVariables() {
        return variables.size();
    }

}
