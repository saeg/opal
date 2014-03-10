package br.usp.each.saeg.opal.requirement;

import java.util.ArrayList;
import java.util.List;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public class EdgeAnalyzer implements Analyzer {

    @Override
    public Edge[] analyze(final Graph<Block> graph, final int vars) {
        final List<Edge> edges = new ArrayList<Edge>();
        for (final Block from : graph) {
            for (final Block to : graph.neighbors(from.id)) {
                edges.add(new Edge(from.id, to.id));
            }
        }
        return edges.toArray(new Edge[edges.size()]);
    }

}
