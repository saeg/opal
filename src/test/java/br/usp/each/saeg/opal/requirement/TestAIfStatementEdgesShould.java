package br.usp.each.saeg.opal.requirement;

import static br.usp.each.saeg.opal.requirement.Util.contains;
import static br.usp.each.saeg.opal.requirement.Util.edge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAIfStatementEdgesShould extends AIfStatement {

    private Edge[] edges;

    @Before
    public void init() {
        edges = new EdgeAnalyzer().analyze(statement, 0);
    }

    @Test
    public void haveThreeEdges() {
        Assert.assertEquals(3, edges.length);
    }

    @Test
    public void haveAnEdgeFromBlock0ToBlock1() {
        Assert.assertTrue(contains(edge(0, 1), edges));
    }

    @Test
    public void haveAnEdgeFromBlock0ToBlock2() {
        Assert.assertTrue(contains(edge(0, 2), edges));
    }

    @Test
    public void haveAnEdgeFromBlock1ToBlock2() {
        Assert.assertTrue(contains(edge(1, 2), edges));
    }

}
