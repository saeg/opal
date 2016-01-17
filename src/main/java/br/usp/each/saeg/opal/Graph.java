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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Graph<K extends Identifiable> implements IGraph<K> {

    private final Map<Integer, K> nodes = new HashMap<Integer, K>();

    private final Map<K, Set<K>> edges = new LinkedHashMap<K, Set<K>>();

    @Override
    public K get(final int id) {
        return nodes.get(id);
    }

    @Override
    public boolean add(final K k) {
        if (!nodes.containsKey(k.id())) {
            nodes.put(k.id(), k);
            edges.put(k, new LinkedHashSet<K>());
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(final int id) {
        final K k = nodes.get(id);

        if (k != null) {
            // verify for in edges
            for (final Set<K> inEdges : edges.values()) {
                if (inEdges.contains(k))
                    return false;
            }

            // verify for out edges
            if (edges.get(k).isEmpty()) {
                nodes.remove(id);
                edges.remove(k);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean adjacent(final int from, final int to) {
        final K fromNode, toNode;

        fromNode = nodes.get(from);
        if (fromNode == null) {
            return false;
        }

        toNode = nodes.get(to);
        if (toNode == null) {
            return false;
        }

        return edges.get(fromNode).contains(toNode);
    }

    @Override
    public Set<K> neighbors(final int id) {
        final K k = nodes.get(id);

        if (k == null) {
            return null;
        }

        return edges.get(k);
    }

    @Override
    public boolean addEdge(final int from, final int to) {
        final K fromNode, toNode;

        fromNode = nodes.get(from);
        if (fromNode == null) {
            return false;
        }

        toNode = nodes.get(to);
        if (toNode == null) {
            return false;
        }

        return edges.get(fromNode).add(toNode);
    }

    @Override
    public boolean removeEdge(final int from, final int to) {
        final K fromNode, toNode;

        fromNode = nodes.get(from);
        if (fromNode == null) {
            return false;
        }

        toNode = nodes.get(to);
        if (toNode == null) {
            return false;
        }

        return edges.get(fromNode).remove(toNode);
    }

    @Override
    public Graph<K> inverse() {
        final Graph<K> g = new Graph<K>();
        for (final K node : this) {
            g.add(node);
        }
        for (final K from : this) {
            for (final K to : edges.get(from)) {
                g.edges.get(to).add(from);
            }
        }
        return g;
    }

    @Override
    public int size() {
        return nodes.size();
    }

    @Override
    public Iterator<K> iterator() {
        return edges.keySet().iterator();
    }

}
