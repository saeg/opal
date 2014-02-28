package br.usp.each.saeg.opal.requirement;

import org.junit.Before;

import br.usp.each.saeg.opal.Block;
import br.usp.each.saeg.opal.Graph;

public abstract class AIfElseStatement {

	protected Graph<Block> statement;

	@Before
	public void setUp() {
		statement = new Graph<Block>();
		statement.add(new Block(0));
		statement.add(new Block(1));
		statement.add(new Block(2));
		statement.add(new Block(3));
		statement.addEdge(0, 1);
		statement.addEdge(0, 2);
		statement.addEdge(1, 3);
		statement.addEdge(2, 3);
	}

}
