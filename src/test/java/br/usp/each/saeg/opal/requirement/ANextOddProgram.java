package br.usp.each.saeg.opal.requirement;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public abstract class ANextOddProgram {

    protected Graph<Block> program;

    protected Map<String, Integer> variables;

    @Before
    public void setUp() {
        program = new Graph<Block>();
        variables = new HashMap<String, Integer>();

        final Block b0 = new Block(0);
        final Block b1 = new Block(1);
        final Block b2 = new Block(2);

        program.add(b0);
        program.add(b1);
        program.add(b2);
        program.addEdge(0, 1);
        program.addEdge(0, 2);
        program.addEdge(1, 2);
        variables.put("this", 0);
        variables.put("x", 1);

        // Block 0 set var x (Parameter) and this.
        b0.def(0);
        b0.def(1);
        b0.puse(1); // If on Block 0

        // x = x + 1
        b1.cuse(1);
        b1.def(1);

        // x = x + 1
        b2.cuse(1);
        b2.def(1);
    }

}
