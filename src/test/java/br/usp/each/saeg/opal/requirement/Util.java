package br.usp.each.saeg.opal.requirement;

import br.usp.each.saeg.commons.ArrayUtils;

public class Util {

    public static boolean contains(final Node node, final Node[] nodes) {
        return ArrayUtils.contains(nodes, node);
    }

    public static boolean contains(final Edge edge, final Edge[] edges) {
        return ArrayUtils.contains(edges, edge);
    }

    public static boolean contains(final Dua dua, final Dua[] duas) {
        return ArrayUtils.contains(duas, dua);
    }

    public static Node node(final int id) {
        return new Node(id);
    }

    public static Edge edge(final int from, final int to) {
        return new Edge(from, to);
    }

    public static Dua cdua(final int def, final int use, final int var) {
        return new Dua(def, new CUse(use), var);
    }

    public static Dua pdua(final int def, final int from, final int to, final int var) {
        return new Dua(def, new PUse(from, to), var);
    }

}
