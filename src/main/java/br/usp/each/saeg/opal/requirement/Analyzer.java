package br.usp.each.saeg.opal.requirement;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public interface Analyzer {

    Requirement[] analyze(Graph<Block> graph, int vars);

}
