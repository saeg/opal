package br.usp.each.saeg.opal.requirement;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public abstract class AMaxProgram {

    protected Graph<Block> program;

    protected Map<String, Integer> variables;

    @Before
    public void setUp() {
        program = new Graph<Block>();
        variables = new HashMap<String, Integer>();

        final Block b0 = new Block(0);
        final Block b1 = new Block(1);
        final Block b2 = new Block(2);
        final Block b3 = new Block(3);
        final Block b4 = new Block(4);
        final Block b5 = new Block(5);

        program.add(b0);
        program.add(b1);
        program.add(b2);
        program.add(b3);
        program.add(b4);
        program.add(b5);
        program.addEdge(0, 1);
        program.addEdge(1, 2);
        program.addEdge(1, 5);
        program.addEdge(2, 3);
        program.addEdge(2, 4);
        program.addEdge(3, 4);
        program.addEdge(4, 1);
        variables.put("this", 0);
        variables.put("array", 1);
        variables.put("array[]", 2);
        variables.put("i", 3);
        variables.put("max", 4);

        /*
         * public int max(int[] array) int i = 0 int max = array[++i]
         */
        b0.def(0);
        b0.def(1);
        b0.def(2);
        b0.def(3);
        b0.def(4);

        // while (i < array.length)
        b1.puse(1);
        b1.puse(3);

        // if (array[i] > max)
        b2.puse(1);
        b2.puse(2);
        b2.puse(3);
        b2.puse(4);

        // max = array[i]
        b3.def(4);
        b3.cuse(1);
        b3.cuse(2);
        b3.cuse(3);

        // i = i + 1
        b4.def(3);
        b4.cuse(3);

        // return max
        b5.cuse(4);
    }

}
