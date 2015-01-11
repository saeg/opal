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

import org.junit.Before;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Program;

public abstract class AMaxProgram {

    protected Program program;

    @Before
    public void setUp() {
        program = new Program();

        final Block b0 = new Block(0);
        final Block b1 = new Block(1);
        final Block b2 = new Block(2);
        final Block b3 = new Block(3);
        final Block b4 = new Block(4);
        final Block b5 = new Block(5);

        program.getGraph().add(b0);
        program.getGraph().add(b1);
        program.getGraph().add(b2);
        program.getGraph().add(b3);
        program.getGraph().add(b4);
        program.getGraph().add(b5);
        program.getGraph().addEdge(0, 1);
        program.getGraph().addEdge(1, 2);
        program.getGraph().addEdge(1, 5);
        program.getGraph().addEdge(2, 3);
        program.getGraph().addEdge(2, 4);
        program.getGraph().addEdge(3, 4);
        program.getGraph().addEdge(4, 1);
        program.addVariable("array", 0);
        program.addVariable("length", 1);
        program.addVariable("i", 2);
        program.addVariable("max", 3);

        /*
         * public static int max(int[] array, int length) int i = 0 int max = array[i++]
         */
        b0.def(program.variable("array"));
        b0.def(program.variable("length"));
        b0.def(program.variable("i"));
        b0.def(program.variable("max"));

        // while (i < length)
        b1.puse(program.variable("i"));
        b1.puse(program.variable("length"));

        // if (array[i] > max)
        b2.puse(program.variable("array"));
        b2.puse(program.variable("i"));
        b2.puse(program.variable("max"));

        // max = array[i]
        b3.def(program.variable("max"));
        b3.cuse(program.variable("array"));
        b3.cuse(program.variable("i"));

        // i = i + 1
        b4.def(program.variable("i"));
        b4.cuse(program.variable("i"));

        // return max
        b5.cuse(program.variable("max"));
    }

}
