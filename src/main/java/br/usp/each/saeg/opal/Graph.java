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
