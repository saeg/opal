package br.usp.each.saeg.opal.requirement;

import static br.usp.each.saeg.opal.requirement.Util.cdua;
import static br.usp.each.saeg.opal.requirement.Util.contains;
import static br.usp.each.saeg.opal.requirement.Util.pdua;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMaxProgramDuasShould extends AMaxProgram {

	private Dua[] duas;

	@Before
	public void init() {
		duas = new DepthFirstDuaAnalyzer().analyze(program, variables.size());
	}

	@Test
	public void haveTwentySixDuas() {
		Assert.assertEquals(26, duas.length);
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt5OfVariableMax() {
		final int var = variables.get("max");
		Assert.assertTrue(contains(cdua(0, 5, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To3OfVariableArraySquareBrackets() {
		final int var = variables.get("array[]");
		Assert.assertTrue(contains(pdua(0, 2, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To4OfVariableArraySquareBrackets() {
		final int var = variables.get("array[]");
		Assert.assertTrue(contains(pdua(0, 2, 4, var), duas));
	}

	@Test
	public void haveAnDefinitionAt4AndUseAt2To3OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(4, 2, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt4AndUseAt2To4OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(4, 2, 4, var), duas));
	}

	@Test
	public void haveAnDefinitionAt3AndUseAt2To3OfVariableMax() {
		final int var = variables.get("max");
		Assert.assertTrue(contains(pdua(3, 2, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt3AndUseAt2To4OfVariableMax() {
		final int var = variables.get("max");
		Assert.assertTrue(contains(pdua(3, 2, 4, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To4OfVariableMax() {
		final int var = variables.get("max");
		Assert.assertTrue(contains(pdua(0, 2, 4, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To3OfVariableMax() {
		final int var = variables.get("max");
		Assert.assertTrue(contains(pdua(0, 2, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To3OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(0, 2, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To4OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(0, 2, 4, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To4OfVariableArray() {
		final int var = variables.get("array");
		Assert.assertTrue(contains(pdua(0, 2, 4, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt2To3OfVariableArray() {
		final int var = variables.get("array");
		Assert.assertTrue(contains(pdua(0, 2, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt4AndUseAt1To5OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(4, 1, 5, var), duas));
	}

	@Test
	public void haveAnDefinitionAt4AndUseAt1To2OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(4, 1, 2, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt3OfVariableArraySquareBrackets() {
		final int var = variables.get("array[]");
		Assert.assertTrue(contains(cdua(0, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt1To5OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(0, 1, 5, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt1To2OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(pdua(0, 1, 2, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt1To5OfVariableArray() {
		final int var = variables.get("array");
		Assert.assertTrue(contains(pdua(0, 1, 5, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt1To2OfVariableArray() {
		final int var = variables.get("array");
		Assert.assertTrue(contains(pdua(0, 1, 2, var), duas));
	}

	@Test
	public void haveAnDefinitionAt4AndUseAt3OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(cdua(4, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt4OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(cdua(0, 4, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt3OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(cdua(0, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt0AndUseAt3OfVariableArray() {
		final int var = variables.get("array");
		Assert.assertTrue(contains(cdua(0, 3, var), duas));
	}

	@Test
	public void haveAnDefinitionAt3AndUseAt5OfVariableMax() {
		final int var = variables.get("max");
		Assert.assertTrue(contains(cdua(3, 5, var), duas));
	}

	@Test
	public void haveAnDefinitionAt4AndUseAt4OfVariableI() {
		final int var = variables.get("i");
		Assert.assertTrue(contains(cdua(4, 4, var), duas));
	}

}
