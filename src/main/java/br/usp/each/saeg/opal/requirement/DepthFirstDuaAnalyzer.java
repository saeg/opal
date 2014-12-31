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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.usp.each.saeg.commons.BitSetIterator;
import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public class DepthFirstDuaAnalyzer implements Analyzer {

    private Graph<Block> graph;

    @Override
    public Dua[] analyze(final Graph<Block> graph, final int vars) {
        this.graph = graph;
        final List<Dua> list = new ArrayList<Dua>();
        for (final Block block : graph) {
            final BitSetIterator it = block.defs();
            while (it.hasNext()) {
                DFS(it.next(), block, list);
            }
        }
        return list.toArray(new Dua[list.size()]);
    }

    /*
     * The search visits every block j which is syntactically reachable from i
     * by some definition-clear path.
     */
    private void DFS(final int var, final Block i, final List<Dua> list) {
        final Set<Integer> queued = new HashSet<Integer>();
        final Block[] queue = new Block[graph.size()];
        int top = 0;
        for (final Block succ : graph.neighbors(i.id)) {
            queue[top++] = succ;
            queued.add(succ.id);
            if (i.isPUse(var)) {
                list.add(new Dua(i.id, new PUse(i.id, succ.id), var));
            }
        }
        while (top > 0) {

            final Block j = queue[--top];

            // is not necessary remove queued mark (since a node is visited only
            // once). We use the queued mark to indicate that a node has already
            // been visited or will be visited soon.

            if (j.isCUse(var)) {
                list.add(new Dua(i.id, new CUse(j.id), var));
            }
            if (j.isPUse(var) && !j.isDef(var)) {
                for (final Block succ : graph.neighbors(j.id)) {
                    list.add(new Dua(i.id, new PUse(j.id, succ.id), var));
                }
            }
            if (j.isDef(var)) {
                // backtrack
                continue;
            }

            for (final Block succ : graph.neighbors(j.id)) {
                if (!queued.contains(succ.id)) {
                    queue[top++] = succ;
                    queued.add(succ.id);
                }
            }
        }
    }

}
