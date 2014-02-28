package br.usp.each.saeg.opal.requirement;

public class PUse extends Use {

	public final int from;

	public final int to;

	public PUse(final int from, final int to) {
		super(Type.P_USE);
		this.from = from;
		this.to = to;
	}

	@Override
	public int id() {
		return to;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		final PUse other = ((PUse) obj);

		if (from != other.from || to != other.to)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + from;
		result = prime * result + to;
		return result;
	}

}
