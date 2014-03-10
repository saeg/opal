package br.usp.each.saeg.opal.requirement;

import static br.usp.each.saeg.opal.requirement.Util.contains;
import static br.usp.each.saeg.opal.requirement.Util.node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.usp.each.saeg.opal.Block;

public class TestADoWhileStatementNodesShould extends ADoWhileStatement {

    private Node[] nodes;

    @Before
    public void init() {
        nodes = new NodeAnalyzer().analyze(statement, 0);
    }

    @Test
    public void haveThreeNodes() {
        Assert.assertEquals(3, nodes.length);
    }

    @Test
    public void haveANodeForEachBlockWithSameId() {
        for (final Block block : statement) {
            Assert.assertTrue(contains(node(block.id), nodes));
        }
    }

}
