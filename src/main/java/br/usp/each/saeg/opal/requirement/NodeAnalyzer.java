package br.usp.each.saeg.opal.requirement;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public class NodeAnalyzer implements Analyzer {

    @Override
    public Node[] analyze(final Graph<Block> graph, final int vars) {
        final Node[] nodes = new Node[graph.size()];
        int i = 0;
        for (final Block node : graph) {
            nodes[i++] = new Node(node.id);
        }
        return nodes;
    }

}
