package br.usp.each.saeg.opal.requirement;

import static br.usp.each.saeg.opal.requirement.Util.cdua;
import static br.usp.each.saeg.opal.requirement.Util.contains;
import static br.usp.each.saeg.opal.requirement.Util.pdua;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNextOddProgramDuasShould extends ANextOddProgram {

    private Dua[] duas;

    @Before
    public void init() {
        duas = new DepthFirstDuaAnalyzer().analyze(program, variables.size());
    }

    @Test
    public void haveFiveDuas() {
        Assert.assertEquals(5, duas.length);
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt1OfVariableX() {
        final int var = variables.get("x");
        Assert.assertTrue(contains(cdua(0, 1, var), duas));
    }

    @Test
    public void haveAnDefinitionAt1AndUseAt2OfVariableX() {
        final int var = variables.get("x");
        Assert.assertTrue(contains(cdua(1, 2, var), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt2OfVariableX() {
        final int var = variables.get("x");
        Assert.assertTrue(contains(cdua(0, 2, var), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt0To2OfVariableX() {
        final int var = variables.get("x");
        Assert.assertTrue(contains(pdua(0, 0, 2, var), duas));
    }

    @Test
    public void haveAnDefinitionAt0AndUseAt0To1OfVariableX() {
        final int var = variables.get("x");
        Assert.assertTrue(contains(pdua(0, 0, 1, var), duas));
    }

}
