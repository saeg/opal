package br.usp.each.saeg.opal.requirement;

public class Node extends Requirement {

	public final int id;

	public Node(final int id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		return id == ((Node) obj).id;
	}

	@Override
	public int hashCode() {
		return 31 + id;
	}

}
