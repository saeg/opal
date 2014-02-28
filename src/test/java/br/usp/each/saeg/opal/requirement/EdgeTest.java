package br.usp.each.saeg.opal.requirement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EdgeTest {

	private Edge edge;

	@Before
	public void setUp() {
		edge = new Edge(1, 2);
	}

	@Test
	public void testFrom() {
		Assert.assertEquals(1, edge.from);
	}

	@Test
	public void testTo() {
		Assert.assertEquals(2, edge.to);
	}

	@Test
	public void testEqualsASelfReturnTrue() {
		Assert.assertTrue(edge.equals(edge));
	}

	@Test
	public void testEqualsANullReturnFalse() {
		Assert.assertFalse(edge.equals(null));
	}

	@Test
	public void testEqualsDifferentClassReturnFalse() {
		Assert.assertFalse(edge.equals(1));
	}

	@Test
	public void testEqualsDifferentFromReturnFalse() {
		final Edge other = new Edge(3, 2);
		Assert.assertFalse(edge.equals(other));
	}

	@Test
	public void testEqualsDifferentToReturnFalse() {
		final Edge other = new Edge(1, 3);
		Assert.assertFalse(edge.equals(other));
	}

	@Test
	public void testEqualsReturnTrue() {
		final Edge other = new Edge(1, 2);
		Assert.assertTrue(edge.equals(other));
	}

	@Test
	public void testDifferentFromReturnOtherHashCode() {
		final Edge other = new Edge(3, 2);
		Assert.assertNotEquals(edge.hashCode(), other.hashCode());
	}

	@Test
	public void testDifferentToReturnOtherHashCode() {
		final Edge other = new Edge(1, 3);
		Assert.assertNotEquals(edge.hashCode(), other.hashCode());
	}

	@Test
	public void testEqualsReturnSameHashCode() {
		final Edge other = new Edge(1, 2);
		Assert.assertEquals(edge.hashCode(), other.hashCode());
	}

}
